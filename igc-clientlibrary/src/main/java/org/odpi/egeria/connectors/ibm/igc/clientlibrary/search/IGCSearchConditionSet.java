/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.clientlibrary.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.*;

/**
 * Manages the composition of multiple {@link IGCSearchCondition} objects into a coherent set of conditions,
 * including how those conditions should be combined (ie. whether AND'd or OR'd).
 */
public class IGCSearchConditionSet {

    private JsonNodeFactory nf = JsonNodeFactory.instance;

    private ArrayNode conditions;
    private String conditionJoin = "and";
    private boolean negateAll = false;

    public IGCSearchConditionSet() {
        this.conditions = nf.arrayNode();
    }

    /**
     * Creates a new set of search criteria initialised with the provided condition.
     *
     * @param condition the condition to initialise the search criteria
     */
    public IGCSearchConditionSet(IGCSearchCondition condition) {
        this();
        addCondition(condition);
    }

    /**
     * Adds the provided condition to the set of criteria to use in the search.
     *
     * @param condition the condition to add to the set of criteria
     */
    public void addCondition(IGCSearchCondition condition) {
        this.conditions.add(condition.getConditionObject());
    }

    /**
     * Set whether to retrieve results for any condition match (true) or all conditions matching (false).
     *
     * @param on set to true to retrieve results that match any condition; false to retrieve results that match all
     */
    public void setMatchAnyCondition(boolean on) {
        this.conditionJoin = on ? "or" : "and";
    }

    /**
     * Set whether to negate all of the specified conditions (true) or not (false).
     *
     * @param on set to true to negate all conditions in this set; false to use conditions as-specified
     */
    public void setNegateAll(boolean on) { this.negateAll = on; }

    /**
     * Adds a set of conditions as nested conditions of this set.
     *
     * @param igcConditions the set of criteria to add as nested criteria
     */
    public void addNestedConditionSet(IGCSearchConditionSet igcConditions) {
        this.conditions.add(igcConditions.getConditionSetObject());
    }

    /**
     * Returns the number of conditions in the set (0 if none).
     *
     * @return int
     */
    public int size() {
        return this.conditions.size();
    }

    /**
     * Returns the JSON structure for the set of conditions.
     *
     * @return ObjectNode
     */
    public ObjectNode getConditionSetObject() {
        ObjectNode condSet = nf.objectNode();
        if (size() > 0) {
            if (negateAll) {
                ArrayNode negatedConditions = nf.arrayNode(conditions.size());
                for (JsonNode condition : this.conditions) {
                    if (condition instanceof ObjectNode) {
                        ObjectNode onCondition = (ObjectNode) condition;
                        JsonNode existingNegated = onCondition.path("negated");
                        BooleanNode negated = nf.booleanNode(true);
                        if (!existingNegated.isMissingNode()) {
                            negated = (BooleanNode) onCondition.get("negated");
                            if (negated.asBoolean()) {
                                negated = nf.booleanNode(false);
                            } else {
                                negated = nf.booleanNode(true);
                            }
                        }
                        // Override any '=' with '<>' (and vice versa) if they should be negated, as these are the
                        // only operators that work on numbers as well as strings (negated: true only works on strings)
                        JsonNode existingOperation = onCondition.path("operator");
                        if (!existingOperation.isMissingNode()) {
                            TextNode operator = (TextNode) existingOperation;
                            if (operator.textValue().equals("=") && negated.booleanValue()) {
                                operator = nf.textNode("<>");
                                negated = null;
                            } else if (operator.textValue().equals("<>") && negated.booleanValue()) {
                                operator = nf.textNode("=");
                                negated = null;
                            }
                            onCondition.set("operator", operator);
                        }
                        if (negated != null) {
                            onCondition.set("negated", negated);
                        }
                        negatedConditions.add(onCondition);
                    }
                }
                condSet.set("conditions", negatedConditions);
                condSet.set("operator", nf.textNode(this.conditionJoin));
            } else {
                condSet.set("conditions", this.conditions);
                condSet.set("operator", nf.textNode(this.conditionJoin));
            }
        }
        return condSet;
    }

}
