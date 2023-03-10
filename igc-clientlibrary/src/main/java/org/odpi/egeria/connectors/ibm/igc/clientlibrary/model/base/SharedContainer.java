/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.ItemList;
import java.util.List;

/**
 * POJO for the {@code shared_container} asset type in IGC, displayed as '{@literal Shared Container}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=SharedContainer.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LocalContainer.class, name = "local_container"),
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("shared_container")
public class SharedContainer extends InformationAsset {

    @JsonProperty("annotations")
    protected List<String> annotations;

    @JsonProperty("local_containers")
    protected LocalContainer localContainers;

    @JsonProperty("mapping_components")
    protected ItemList<MappingComponent> mappingComponents;

    @JsonProperty("parameter_sets")
    protected ItemList<DsparameterSet> parameterSets;

    @JsonProperty("parameters")
    protected ItemList<Dsparameter> parameters;

    @JsonProperty("referenced_by_containers")
    protected ItemList<SharedContainer> referencedByContainers;

    @JsonProperty("referenced_by_stages")
    protected ItemList<Stage> referencedByStages;

    @JsonProperty("references_containers")
    protected ItemList<SharedContainer> referencesContainers;

    @JsonProperty("shared_containers")
    protected SharedContainer sharedContainers;

    @JsonProperty("source_mappings")
    protected ItemList<MainObject> sourceMappings;

    @JsonProperty("stages")
    protected ItemList<Stage> stages;

    @JsonProperty("target_mappings")
    protected ItemList<MainObject> targetMappings;

    @JsonProperty("transformation_project")
    protected TransformationProject transformationProject;

    /**
     * Valid values are:
     * <ul>
     *   <li>SERVER (displayed in the UI as 'SERVER')</li>
     *   <li>MAINFRAME (displayed in the UI as 'MAINFRAME')</li>
     *   <li>SEQUENCE (displayed in the UI as 'SEQUENCE')</li>
     *   <li>PARALLEL (displayed in the UI as 'PARALLEL')</li>
     * </ul>
     */
    @JsonProperty("type")
    protected String type;

    @JsonProperty("version")
    protected String version;

    /**
     * Retrieve the {@code annotations} property (displayed as '{@literal Annotations}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("annotations")
    public List<String> getAnnotations() { return this.annotations; }

    /**
     * Set the {@code annotations} property (displayed as {@code Annotations}) of the object.
     * @param annotations the value to set
     */
    @JsonProperty("annotations")
    public void setAnnotations(List<String> annotations) { this.annotations = annotations; }

    /**
     * Retrieve the {@code local_containers} property (displayed as '{@literal Local Containers}') of the object.
     * @return {@code LocalContainer}
     */
    @JsonProperty("local_containers")
    public LocalContainer getLocalContainers() { return this.localContainers; }

    /**
     * Set the {@code local_containers} property (displayed as {@code Local Containers}) of the object.
     * @param localContainers the value to set
     */
    @JsonProperty("local_containers")
    public void setLocalContainers(LocalContainer localContainers) { this.localContainers = localContainers; }

    /**
     * Retrieve the {@code mapping_components} property (displayed as '{@literal Mapping Components}') of the object.
     * @return {@code ItemList<MappingComponent>}
     */
    @JsonProperty("mapping_components")
    public ItemList<MappingComponent> getMappingComponents() { return this.mappingComponents; }

    /**
     * Set the {@code mapping_components} property (displayed as {@code Mapping Components}) of the object.
     * @param mappingComponents the value to set
     */
    @JsonProperty("mapping_components")
    public void setMappingComponents(ItemList<MappingComponent> mappingComponents) { this.mappingComponents = mappingComponents; }

    /**
     * Retrieve the {@code parameter_sets} property (displayed as '{@literal Parameter Sets}') of the object.
     * @return {@code ItemList<DsparameterSet>}
     */
    @JsonProperty("parameter_sets")
    public ItemList<DsparameterSet> getParameterSets() { return this.parameterSets; }

    /**
     * Set the {@code parameter_sets} property (displayed as {@code Parameter Sets}) of the object.
     * @param parameterSets the value to set
     */
    @JsonProperty("parameter_sets")
    public void setParameterSets(ItemList<DsparameterSet> parameterSets) { this.parameterSets = parameterSets; }

    /**
     * Retrieve the {@code parameters} property (displayed as '{@literal Parameters}') of the object.
     * @return {@code ItemList<Dsparameter>}
     */
    @JsonProperty("parameters")
    public ItemList<Dsparameter> getParameters() { return this.parameters; }

    /**
     * Set the {@code parameters} property (displayed as {@code Parameters}) of the object.
     * @param parameters the value to set
     */
    @JsonProperty("parameters")
    public void setParameters(ItemList<Dsparameter> parameters) { this.parameters = parameters; }

    /**
     * Retrieve the {@code referenced_by_containers} property (displayed as '{@literal Referenced by Containers}') of the object.
     * @return {@code ItemList<SharedContainer>}
     */
    @JsonProperty("referenced_by_containers")
    public ItemList<SharedContainer> getReferencedByContainers() { return this.referencedByContainers; }

    /**
     * Set the {@code referenced_by_containers} property (displayed as {@code Referenced by Containers}) of the object.
     * @param referencedByContainers the value to set
     */
    @JsonProperty("referenced_by_containers")
    public void setReferencedByContainers(ItemList<SharedContainer> referencedByContainers) { this.referencedByContainers = referencedByContainers; }

    /**
     * Retrieve the {@code referenced_by_stages} property (displayed as '{@literal Referenced by Stages}') of the object.
     * @return {@code ItemList<Stage>}
     */
    @JsonProperty("referenced_by_stages")
    public ItemList<Stage> getReferencedByStages() { return this.referencedByStages; }

    /**
     * Set the {@code referenced_by_stages} property (displayed as {@code Referenced by Stages}) of the object.
     * @param referencedByStages the value to set
     */
    @JsonProperty("referenced_by_stages")
    public void setReferencedByStages(ItemList<Stage> referencedByStages) { this.referencedByStages = referencedByStages; }

    /**
     * Retrieve the {@code references_containers} property (displayed as '{@literal References Containers}') of the object.
     * @return {@code ItemList<SharedContainer>}
     */
    @JsonProperty("references_containers")
    public ItemList<SharedContainer> getReferencesContainers() { return this.referencesContainers; }

    /**
     * Set the {@code references_containers} property (displayed as {@code References Containers}) of the object.
     * @param referencesContainers the value to set
     */
    @JsonProperty("references_containers")
    public void setReferencesContainers(ItemList<SharedContainer> referencesContainers) { this.referencesContainers = referencesContainers; }

    /**
     * Retrieve the {@code shared_containers} property (displayed as '{@literal Shared Containers}') of the object.
     * @return {@code SharedContainer}
     */
    @JsonProperty("shared_containers")
    public SharedContainer getSharedContainers() { return this.sharedContainers; }

    /**
     * Set the {@code shared_containers} property (displayed as {@code Shared Containers}) of the object.
     * @param sharedContainers the value to set
     */
    @JsonProperty("shared_containers")
    public void setSharedContainers(SharedContainer sharedContainers) { this.sharedContainers = sharedContainers; }

    /**
     * Retrieve the {@code source_mappings} property (displayed as '{@literal Source Mappings}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("source_mappings")
    public ItemList<MainObject> getSourceMappings() { return this.sourceMappings; }

    /**
     * Set the {@code source_mappings} property (displayed as {@code Source Mappings}) of the object.
     * @param sourceMappings the value to set
     */
    @JsonProperty("source_mappings")
    public void setSourceMappings(ItemList<MainObject> sourceMappings) { this.sourceMappings = sourceMappings; }

    /**
     * Retrieve the {@code stages} property (displayed as '{@literal Stages}') of the object.
     * @return {@code ItemList<Stage>}
     */
    @JsonProperty("stages")
    public ItemList<Stage> getStages() { return this.stages; }

    /**
     * Set the {@code stages} property (displayed as {@code Stages}) of the object.
     * @param stages the value to set
     */
    @JsonProperty("stages")
    public void setStages(ItemList<Stage> stages) { this.stages = stages; }

    /**
     * Retrieve the {@code target_mappings} property (displayed as '{@literal Target Mappings}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("target_mappings")
    public ItemList<MainObject> getTargetMappings() { return this.targetMappings; }

    /**
     * Set the {@code target_mappings} property (displayed as {@code Target Mappings}) of the object.
     * @param targetMappings the value to set
     */
    @JsonProperty("target_mappings")
    public void setTargetMappings(ItemList<MainObject> targetMappings) { this.targetMappings = targetMappings; }

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
     * Retrieve the {@code version} property (displayed as '{@literal Version}') of the object.
     * @return {@code String}
     */
    @JsonProperty("version")
    public String getVersion() { return this.version; }

    /**
     * Set the {@code version} property (displayed as {@code Version}) of the object.
     * @param version the value to set
     */
    @JsonProperty("version")
    public void setVersion(String version) { this.version = version; }

}
