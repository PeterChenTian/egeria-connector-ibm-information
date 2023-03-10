/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.ItemList;
import java.util.List;

/**
 * POJO for the {@code data_rule_set} asset type in IGC, displayed as '{@literal Data Rule Set}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DataRuleSet.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("data_rule_set")
public class DataRuleSet extends InformationAsset {

    @JsonProperty("benchmark")
    protected List<String> benchmark;

    @JsonProperty("contact")
    protected ItemList<Steward> contact;

    @JsonProperty("data_policies")
    protected ItemList<MainObject> dataPolicies;

    @JsonProperty("data_rule_set_definitions")
    protected NonPublishedDataRuleSet dataRuleSetDefinitions;

    @JsonProperty("execution_history")
    protected ItemList<DataRuleResults> executionHistory;

    @JsonProperty("implemented_bindings")
    protected ItemList<DataItem> implementedBindings;

    @JsonProperty("metrics")
    protected ItemList<Metric> metrics;

    @JsonProperty("project")
    protected List<String> project;

    /**
     * Valid values are:
     * <ul>
     *   <li>CANDIDATE (displayed in the UI as 'CANDIDATE')</li>
     *   <li>ACCEPTED (displayed in the UI as 'ACCEPTED')</li>
     *   <li>STANDARD (displayed in the UI as 'STANDARD')</li>
     *   <li>DEPRECATED (displayed in the UI as 'DEPRECATED')</li>
     *   <li>DRAFT (displayed in the UI as 'DRAFT')</li>
     *   <li>IN_PROCESS (displayed in the UI as 'IN_PROCESS')</li>
     *   <li>REJECTED (displayed in the UI as 'REJECTED')</li>
     *   <li>SUGGESTED (displayed in the UI as 'SUGGESTED')</li>
     *   <li>ERROR (displayed in the UI as 'ERROR')</li>
     * </ul>
     */
    @JsonProperty("status")
    protected String status;

    /**
     * Retrieve the {@code benchmark} property (displayed as '{@literal Benchmark}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("benchmark")
    public List<String> getBenchmark() { return this.benchmark; }

    /**
     * Set the {@code benchmark} property (displayed as {@code Benchmark}) of the object.
     * @param benchmark the value to set
     */
    @JsonProperty("benchmark")
    public void setBenchmark(List<String> benchmark) { this.benchmark = benchmark; }

    /**
     * Retrieve the {@code contact} property (displayed as '{@literal Contact}') of the object.
     * @return {@code ItemList<Steward>}
     */
    @JsonProperty("contact")
    public ItemList<Steward> getContact() { return this.contact; }

    /**
     * Set the {@code contact} property (displayed as {@code Contact}) of the object.
     * @param contact the value to set
     */
    @JsonProperty("contact")
    public void setContact(ItemList<Steward> contact) { this.contact = contact; }

    /**
     * Retrieve the {@code data_policies} property (displayed as '{@literal Data Policies}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("data_policies")
    public ItemList<MainObject> getDataPolicies() { return this.dataPolicies; }

    /**
     * Set the {@code data_policies} property (displayed as {@code Data Policies}) of the object.
     * @param dataPolicies the value to set
     */
    @JsonProperty("data_policies")
    public void setDataPolicies(ItemList<MainObject> dataPolicies) { this.dataPolicies = dataPolicies; }

    /**
     * Retrieve the {@code data_rule_set_definitions} property (displayed as '{@literal Data Rule Set Definitions}') of the object.
     * @return {@code NonPublishedDataRuleSet}
     */
    @JsonProperty("data_rule_set_definitions")
    public NonPublishedDataRuleSet getDataRuleSetDefinitions() { return this.dataRuleSetDefinitions; }

    /**
     * Set the {@code data_rule_set_definitions} property (displayed as {@code Data Rule Set Definitions}) of the object.
     * @param dataRuleSetDefinitions the value to set
     */
    @JsonProperty("data_rule_set_definitions")
    public void setDataRuleSetDefinitions(NonPublishedDataRuleSet dataRuleSetDefinitions) { this.dataRuleSetDefinitions = dataRuleSetDefinitions; }

    /**
     * Retrieve the {@code execution_history} property (displayed as '{@literal Execution History}') of the object.
     * @return {@code ItemList<DataRuleResults>}
     */
    @JsonProperty("execution_history")
    public ItemList<DataRuleResults> getExecutionHistory() { return this.executionHistory; }

    /**
     * Set the {@code execution_history} property (displayed as {@code Execution History}) of the object.
     * @param executionHistory the value to set
     */
    @JsonProperty("execution_history")
    public void setExecutionHistory(ItemList<DataRuleResults> executionHistory) { this.executionHistory = executionHistory; }

    /**
     * Retrieve the {@code implemented_bindings} property (displayed as '{@literal Implemented Bindings}') of the object.
     * @return {@code ItemList<DataItem>}
     */
    @JsonProperty("implemented_bindings")
    public ItemList<DataItem> getImplementedBindings() { return this.implementedBindings; }

    /**
     * Set the {@code implemented_bindings} property (displayed as {@code Implemented Bindings}) of the object.
     * @param implementedBindings the value to set
     */
    @JsonProperty("implemented_bindings")
    public void setImplementedBindings(ItemList<DataItem> implementedBindings) { this.implementedBindings = implementedBindings; }

    /**
     * Retrieve the {@code metrics} property (displayed as '{@literal Metrics}') of the object.
     * @return {@code ItemList<Metric>}
     */
    @JsonProperty("metrics")
    public ItemList<Metric> getMetrics() { return this.metrics; }

    /**
     * Set the {@code metrics} property (displayed as {@code Metrics}) of the object.
     * @param metrics the value to set
     */
    @JsonProperty("metrics")
    public void setMetrics(ItemList<Metric> metrics) { this.metrics = metrics; }

    /**
     * Retrieve the {@code project} property (displayed as '{@literal Project}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("project")
    public List<String> getProject() { return this.project; }

    /**
     * Set the {@code project} property (displayed as {@code Project}) of the object.
     * @param project the value to set
     */
    @JsonProperty("project")
    public void setProject(List<String> project) { this.project = project; }

    /**
     * Retrieve the {@code status} property (displayed as '{@literal Status}') of the object.
     * @return {@code String}
     */
    @JsonProperty("status")
    public String getStatus() { return this.status; }

    /**
     * Set the {@code status} property (displayed as {@code Status}) of the object.
     * @param status the value to set
     */
    @JsonProperty("status")
    public void setStatus(String status) { this.status = status; }

}
