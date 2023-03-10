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
 * POJO for the {@code term} asset type in IGC, displayed as '{@literal Term}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=Term.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("term")
public class Term extends InformationAsset {

    @JsonProperty("Automation_Rules")
    protected ItemList<MainObject> automationRules;

    @JsonProperty("abbreviation")
    protected String abbreviation;

    @JsonProperty("additional_abbreviation")
    protected String additionalAbbreviation;

    @JsonProperty("assigned_assets")
    protected ItemList<InformationAsset> assignedAssets;

    @JsonProperty("assigned_terms")
    protected ItemList<Term> assignedTerms;

    @JsonProperty("category_path")
    protected ItemList<Category> categoryPath;

    @JsonProperty("example")
    protected String example;

    /**
     * Valid values are:
     * <ul>
     *   <li>PUBLISHED (displayed in the UI as 'PUBLISHED')</li>
     *   <li>DRAFT (displayed in the UI as 'DRAFT')</li>
     * </ul>
     */
    @JsonProperty("glossary_type")
    protected String glossaryType;

    @JsonProperty("has_a")
    protected Term hasA;

    @JsonProperty("has_a_term")
    protected ItemList<Term> hasATerm;

    @JsonProperty("has_types")
    protected ItemList<Term> hasTypes;

    @JsonProperty("is_a_type_of")
    protected ItemList<Term> isATypeOf;

    @JsonProperty("is_modifier")
    protected Boolean isModifier;

    @JsonProperty("is_of")
    protected ItemList<Term> isOf;

    @JsonProperty("language")
    protected String language;

    @JsonProperty("parent_category")
    protected Category parentCategory;

    @JsonProperty("preferred_synonym")
    protected Term preferredSynonym;

    @JsonProperty("referencing_categories")
    protected ItemList<Category> referencingCategories;

    @JsonProperty("related_terms")
    protected ItemList<Term> relatedTerms;

    @JsonProperty("replaced_by")
    protected Term replacedBy;

    @JsonProperty("replaces")
    protected ItemList<Term> replaces;

    /**
     * Valid values are:
     * <ul>
     *   <li>CANDIDATE (displayed in the UI as 'Candidate')</li>
     *   <li>ACCEPTED (displayed in the UI as 'Accepted')</li>
     *   <li>STANDARD (displayed in the UI as 'Standard')</li>
     *   <li>DEPRECATED (displayed in the UI as 'Deprecated')</li>
     * </ul>
     */
    @JsonProperty("status")
    protected String status;

    @JsonProperty("synonyms")
    protected ItemList<Term> synonyms;

    @JsonProperty("translations")
    protected ItemList<Term> translations;

    /**
     * Valid values are:
     * <ul>
     *   <li>NONE (displayed in the UI as 'None')</li>
     *   <li>PRIME (displayed in the UI as 'Primary')</li>
     *   <li>CLASS (displayed in the UI as 'Secondary')</li>
     * </ul>
     */
    @JsonProperty("type")
    protected String type;

    @JsonProperty("usage")
    protected String usage;

    /**
     * Valid values are:
     * <ul>
     *   <li>DRAFT (displayed in the UI as 'DRAFT')</li>
     *   <li>WAITING_APPROVAL (displayed in the UI as 'WAITING_APPROVAL')</li>
     *   <li>APPROVED (displayed in the UI as 'APPROVED')</li>
     * </ul>
     */
    @JsonProperty("workflow_current_state")
    protected List<String> workflowCurrentState;

    /**
     * Valid values are:
     * <ul>
     *   <li>DRAFT (displayed in the UI as 'DRAFT')</li>
     *   <li>WAITING_APPROVAL (displayed in the UI as 'WAITING_APPROVAL')</li>
     *   <li>APPROVED (displayed in the UI as 'APPROVED')</li>
     * </ul>
     */
    @JsonProperty("workflow_stored_state")
    protected List<String> workflowStoredState;

    /**
     * Retrieve the {@code Automation_Rules} property (displayed as '{@literal Automation Rules}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("Automation_Rules")
    public ItemList<MainObject> getAutomationRules() { return this.automationRules; }

    /**
     * Set the {@code Automation_Rules} property (displayed as {@code Automation Rules}) of the object.
     * @param automationRules the value to set
     */
    @JsonProperty("Automation_Rules")
    public void setAutomationRules(ItemList<MainObject> automationRules) { this.automationRules = automationRules; }

    /**
     * Retrieve the {@code abbreviation} property (displayed as '{@literal Abbreviation}') of the object.
     * @return {@code String}
     */
    @JsonProperty("abbreviation")
    public String getAbbreviation() { return this.abbreviation; }

    /**
     * Set the {@code abbreviation} property (displayed as {@code Abbreviation}) of the object.
     * @param abbreviation the value to set
     */
    @JsonProperty("abbreviation")
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    /**
     * Retrieve the {@code additional_abbreviation} property (displayed as '{@literal Additional Abbreviation}') of the object.
     * @return {@code String}
     */
    @JsonProperty("additional_abbreviation")
    public String getAdditionalAbbreviation() { return this.additionalAbbreviation; }

    /**
     * Set the {@code additional_abbreviation} property (displayed as {@code Additional Abbreviation}) of the object.
     * @param additionalAbbreviation the value to set
     */
    @JsonProperty("additional_abbreviation")
    public void setAdditionalAbbreviation(String additionalAbbreviation) { this.additionalAbbreviation = additionalAbbreviation; }

    /**
     * Retrieve the {@code assigned_assets} property (displayed as '{@literal Assigned Assets}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("assigned_assets")
    public ItemList<InformationAsset> getAssignedAssets() { return this.assignedAssets; }

    /**
     * Set the {@code assigned_assets} property (displayed as {@code Assigned Assets}) of the object.
     * @param assignedAssets the value to set
     */
    @JsonProperty("assigned_assets")
    public void setAssignedAssets(ItemList<InformationAsset> assignedAssets) { this.assignedAssets = assignedAssets; }

    /**
     * Retrieve the {@code assigned_terms} property (displayed as '{@literal Assigned Terms}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("assigned_terms")
    public ItemList<Term> getAssignedTerms() { return this.assignedTerms; }

    /**
     * Set the {@code assigned_terms} property (displayed as {@code Assigned Terms}) of the object.
     * @param assignedTerms the value to set
     */
    @JsonProperty("assigned_terms")
    public void setAssignedTerms(ItemList<Term> assignedTerms) { this.assignedTerms = assignedTerms; }

    /**
     * Retrieve the {@code category_path} property (displayed as '{@literal Category Path}') of the object.
     * @return {@code ItemList<Category>}
     */
    @JsonProperty("category_path")
    public ItemList<Category> getCategoryPath() { return this.categoryPath; }

    /**
     * Set the {@code category_path} property (displayed as {@code Category Path}) of the object.
     * @param categoryPath the value to set
     */
    @JsonProperty("category_path")
    public void setCategoryPath(ItemList<Category> categoryPath) { this.categoryPath = categoryPath; }

    /**
     * Retrieve the {@code example} property (displayed as '{@literal Example}') of the object.
     * @return {@code String}
     */
    @JsonProperty("example")
    public String getExample() { return this.example; }

    /**
     * Set the {@code example} property (displayed as {@code Example}) of the object.
     * @param example the value to set
     */
    @JsonProperty("example")
    public void setExample(String example) { this.example = example; }

    /**
     * Retrieve the {@code glossary_type} property (displayed as '{@literal Glossary Type}') of the object.
     * @return {@code String}
     */
    @JsonProperty("glossary_type")
    public String getGlossaryType() { return this.glossaryType; }

    /**
     * Set the {@code glossary_type} property (displayed as {@code Glossary Type}) of the object.
     * @param glossaryType the value to set
     */
    @JsonProperty("glossary_type")
    public void setGlossaryType(String glossaryType) { this.glossaryType = glossaryType; }

    /**
     * Retrieve the {@code has_a} property (displayed as '{@literal Has A}') of the object.
     * @return {@code Term}
     */
    @JsonProperty("has_a")
    public Term getHasA() { return this.hasA; }

    /**
     * Set the {@code has_a} property (displayed as {@code Has A}) of the object.
     * @param hasA the value to set
     */
    @JsonProperty("has_a")
    public void setHasA(Term hasA) { this.hasA = hasA; }

    /**
     * Retrieve the {@code has_a_term} property (displayed as '{@literal Has A}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("has_a_term")
    public ItemList<Term> getHasATerm() { return this.hasATerm; }

    /**
     * Set the {@code has_a_term} property (displayed as {@code Has A}) of the object.
     * @param hasATerm the value to set
     */
    @JsonProperty("has_a_term")
    public void setHasATerm(ItemList<Term> hasATerm) { this.hasATerm = hasATerm; }

    /**
     * Retrieve the {@code has_types} property (displayed as '{@literal Has Types}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("has_types")
    public ItemList<Term> getHasTypes() { return this.hasTypes; }

    /**
     * Set the {@code has_types} property (displayed as {@code Has Types}) of the object.
     * @param hasTypes the value to set
     */
    @JsonProperty("has_types")
    public void setHasTypes(ItemList<Term> hasTypes) { this.hasTypes = hasTypes; }

    /**
     * Retrieve the {@code is_a_type_of} property (displayed as '{@literal Is a Type Of}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("is_a_type_of")
    public ItemList<Term> getIsATypeOf() { return this.isATypeOf; }

    /**
     * Set the {@code is_a_type_of} property (displayed as {@code Is a Type Of}) of the object.
     * @param isATypeOf the value to set
     */
    @JsonProperty("is_a_type_of")
    public void setIsATypeOf(ItemList<Term> isATypeOf) { this.isATypeOf = isATypeOf; }

    /**
     * Retrieve the {@code is_modifier} property (displayed as '{@literal Is Modifier}') of the object.
     * @return {@code Boolean}
     */
    @JsonProperty("is_modifier")
    public Boolean getIsModifier() { return this.isModifier; }

    /**
     * Set the {@code is_modifier} property (displayed as {@code Is Modifier}) of the object.
     * @param isModifier the value to set
     */
    @JsonProperty("is_modifier")
    public void setIsModifier(Boolean isModifier) { this.isModifier = isModifier; }

    /**
     * Retrieve the {@code is_of} property (displayed as '{@literal Is Of}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("is_of")
    public ItemList<Term> getIsOf() { return this.isOf; }

    /**
     * Set the {@code is_of} property (displayed as {@code Is Of}) of the object.
     * @param isOf the value to set
     */
    @JsonProperty("is_of")
    public void setIsOf(ItemList<Term> isOf) { this.isOf = isOf; }

    /**
     * Retrieve the {@code language} property (displayed as '{@literal Language}') of the object.
     * @return {@code String}
     */
    @JsonProperty("language")
    public String getLanguage() { return this.language; }

    /**
     * Set the {@code language} property (displayed as {@code Language}) of the object.
     * @param language the value to set
     */
    @JsonProperty("language")
    public void setLanguage(String language) { this.language = language; }

    /**
     * Retrieve the {@code parent_category} property (displayed as '{@literal Parent Category}') of the object.
     * @return {@code Category}
     */
    @JsonProperty("parent_category")
    public Category getParentCategory() { return this.parentCategory; }

    /**
     * Set the {@code parent_category} property (displayed as {@code Parent Category}) of the object.
     * @param parentCategory the value to set
     */
    @JsonProperty("parent_category")
    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }

    /**
     * Retrieve the {@code preferred_synonym} property (displayed as '{@literal Preferred Synonym}') of the object.
     * @return {@code Term}
     */
    @JsonProperty("preferred_synonym")
    public Term getPreferredSynonym() { return this.preferredSynonym; }

    /**
     * Set the {@code preferred_synonym} property (displayed as {@code Preferred Synonym}) of the object.
     * @param preferredSynonym the value to set
     */
    @JsonProperty("preferred_synonym")
    public void setPreferredSynonym(Term preferredSynonym) { this.preferredSynonym = preferredSynonym; }

    /**
     * Retrieve the {@code referencing_categories} property (displayed as '{@literal Referencing Categories}') of the object.
     * @return {@code ItemList<Category>}
     */
    @JsonProperty("referencing_categories")
    public ItemList<Category> getReferencingCategories() { return this.referencingCategories; }

    /**
     * Set the {@code referencing_categories} property (displayed as {@code Referencing Categories}) of the object.
     * @param referencingCategories the value to set
     */
    @JsonProperty("referencing_categories")
    public void setReferencingCategories(ItemList<Category> referencingCategories) { this.referencingCategories = referencingCategories; }

    /**
     * Retrieve the {@code related_terms} property (displayed as '{@literal Related Terms}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("related_terms")
    public ItemList<Term> getRelatedTerms() { return this.relatedTerms; }

    /**
     * Set the {@code related_terms} property (displayed as {@code Related Terms}) of the object.
     * @param relatedTerms the value to set
     */
    @JsonProperty("related_terms")
    public void setRelatedTerms(ItemList<Term> relatedTerms) { this.relatedTerms = relatedTerms; }

    /**
     * Retrieve the {@code replaced_by} property (displayed as '{@literal Replaced By}') of the object.
     * @return {@code Term}
     */
    @JsonProperty("replaced_by")
    public Term getReplacedBy() { return this.replacedBy; }

    /**
     * Set the {@code replaced_by} property (displayed as {@code Replaced By}) of the object.
     * @param replacedBy the value to set
     */
    @JsonProperty("replaced_by")
    public void setReplacedBy(Term replacedBy) { this.replacedBy = replacedBy; }

    /**
     * Retrieve the {@code replaces} property (displayed as '{@literal Replaces}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("replaces")
    public ItemList<Term> getReplaces() { return this.replaces; }

    /**
     * Set the {@code replaces} property (displayed as {@code Replaces}) of the object.
     * @param replaces the value to set
     */
    @JsonProperty("replaces")
    public void setReplaces(ItemList<Term> replaces) { this.replaces = replaces; }

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

    /**
     * Retrieve the {@code synonyms} property (displayed as '{@literal Synonyms}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("synonyms")
    public ItemList<Term> getSynonyms() { return this.synonyms; }

    /**
     * Set the {@code synonyms} property (displayed as {@code Synonyms}) of the object.
     * @param synonyms the value to set
     */
    @JsonProperty("synonyms")
    public void setSynonyms(ItemList<Term> synonyms) { this.synonyms = synonyms; }

    /**
     * Retrieve the {@code translations} property (displayed as '{@literal Translations}') of the object.
     * @return {@code ItemList<Term>}
     */
    @JsonProperty("translations")
    public ItemList<Term> getTranslations() { return this.translations; }

    /**
     * Set the {@code translations} property (displayed as {@code Translations}) of the object.
     * @param translations the value to set
     */
    @JsonProperty("translations")
    public void setTranslations(ItemList<Term> translations) { this.translations = translations; }

    /**
     * Retrieve the {@code type} property (displayed as '{@literal Type}') of the object.
     * @return {@code String}
     */
    @JsonProperty("type")
    public String getTheType() { return this.type; }

    /**
     * Set the {@code type} property (displayed as {@code Type}) of the object.
     * @param type the value to set
     */
    @JsonProperty("type")
    public void setTheType(String type) { this.type = type; }

    /**
     * Retrieve the {@code usage} property (displayed as '{@literal Usage}') of the object.
     * @return {@code String}
     */
    @JsonProperty("usage")
    public String getUsage() { return this.usage; }

    /**
     * Set the {@code usage} property (displayed as {@code Usage}) of the object.
     * @param usage the value to set
     */
    @JsonProperty("usage")
    public void setUsage(String usage) { this.usage = usage; }

    /**
     * Retrieve the {@code workflow_current_state} property (displayed as '{@literal Workflow Current State}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("workflow_current_state")
    public List<String> getWorkflowCurrentState() { return this.workflowCurrentState; }

    /**
     * Set the {@code workflow_current_state} property (displayed as {@code Workflow Current State}) of the object.
     * @param workflowCurrentState the value to set
     */
    @JsonProperty("workflow_current_state")
    public void setWorkflowCurrentState(List<String> workflowCurrentState) { this.workflowCurrentState = workflowCurrentState; }

    /**
     * Retrieve the {@code workflow_stored_state} property (displayed as '{@literal Workflow Stored State}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("workflow_stored_state")
    public List<String> getWorkflowStoredState() { return this.workflowStoredState; }

    /**
     * Set the {@code workflow_stored_state} property (displayed as {@code Workflow Stored State}) of the object.
     * @param workflowStoredState the value to set
     */
    @JsonProperty("workflow_stored_state")
    public void setWorkflowStoredState(List<String> workflowStoredState) { this.workflowStoredState = workflowStoredState; }

}
