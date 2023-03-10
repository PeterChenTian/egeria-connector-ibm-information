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

/**
 * POJO for the {@code standardization_rule_set} asset type in IGC, displayed as '{@literal Standardization Rule Set}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=StandardizationRuleSet.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("standardization_rule_set")
public class StandardizationRuleSet extends InformationAsset {

    @JsonProperty("data_quality_specifications")
    protected ItemList<StandardizationObject> dataQualitySpecifications;

    @JsonProperty("folder")
    protected Dsfolder folder;

    @JsonProperty("help_text")
    protected String helpText;

    @JsonProperty("transformation_project")
    protected TransformationProject transformationProject;

    @JsonProperty("type")
    protected String type;

    @JsonProperty("used_by_stages")
    protected ItemList<Stage> usedByStages;

    /**
     * Retrieve the {@code data_quality_specifications} property (displayed as '{@literal Data Quality Specifications}') of the object.
     * @return {@code ItemList<StandardizationObject>}
     */
    @JsonProperty("data_quality_specifications")
    public ItemList<StandardizationObject> getDataQualitySpecifications() { return this.dataQualitySpecifications; }

    /**
     * Set the {@code data_quality_specifications} property (displayed as {@code Data Quality Specifications}) of the object.
     * @param dataQualitySpecifications the value to set
     */
    @JsonProperty("data_quality_specifications")
    public void setDataQualitySpecifications(ItemList<StandardizationObject> dataQualitySpecifications) { this.dataQualitySpecifications = dataQualitySpecifications; }

    /**
     * Retrieve the {@code folder} property (displayed as '{@literal Folder}') of the object.
     * @return {@code Dsfolder}
     */
    @JsonProperty("folder")
    public Dsfolder getFolder() { return this.folder; }

    /**
     * Set the {@code folder} property (displayed as {@code Folder}) of the object.
     * @param folder the value to set
     */
    @JsonProperty("folder")
    public void setFolder(Dsfolder folder) { this.folder = folder; }

    /**
     * Retrieve the {@code help_text} property (displayed as '{@literal Long Description}') of the object.
     * @return {@code String}
     */
    @JsonProperty("help_text")
    public String getHelpText() { return this.helpText; }

    /**
     * Set the {@code help_text} property (displayed as {@code Long Description}) of the object.
     * @param helpText the value to set
     */
    @JsonProperty("help_text")
    public void setHelpText(String helpText) { this.helpText = helpText; }

    /**
     * Retrieve the {@code transformation_project} property (displayed as '{@literal Transformation Project}') of the object.
     * @return {@code TransformationProject}
     */
    @JsonProperty("transformation_project")
    public TransformationProject getTransformationProject() { return this.transformationProject; }

    /**
     * Set the {@code transformation_project} property (displayed as {@code Transformation Project}) of the object.
     * @param transformationProject the value to set
     */
    @JsonProperty("transformation_project")
    public void setTransformationProject(TransformationProject transformationProject) { this.transformationProject = transformationProject; }

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
     * Retrieve the {@code used_by_stages} property (displayed as '{@literal Stages}') of the object.
     * @return {@code ItemList<Stage>}
     */
    @JsonProperty("used_by_stages")
    public ItemList<Stage> getUsedByStages() { return this.usedByStages; }

    /**
     * Set the {@code used_by_stages} property (displayed as {@code Stages}) of the object.
     * @param usedByStages the value to set
     */
    @JsonProperty("used_by_stages")
    public void setUsedByStages(ItemList<Stage> usedByStages) { this.usedByStages = usedByStages; }

}
