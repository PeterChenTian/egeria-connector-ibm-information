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
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.Reference;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.ItemList;

/**
 * POJO for the {@code extension_mapping} asset type in IGC, displayed as '{@literal Extension Mapping}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=ExtensionMapping.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("extension_mapping")
public class ExtensionMapping extends Reference {

    @JsonProperty("description")
    protected String description;

    @JsonProperty("extension_mapping_document")
    protected MainObject extensionMappingDocument;

    @JsonProperty("function")
    protected String function;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("rule")
    protected String rule;

    @JsonProperty("sources")
    protected ItemList<InformationAsset> sources;

    @JsonProperty("targets")
    protected ItemList<InformationAsset> targets;

    /**
     * Retrieve the {@code description} property (displayed as '{@literal Description}') of the object.
     * @return {@code String}
     */
    @JsonProperty("description")
    public String getDescription() { return this.description; }

    /**
     * Set the {@code description} property (displayed as {@code Description}) of the object.
     * @param description the value to set
     */
    @JsonProperty("description")
    public void setDescription(String description) { this.description = description; }

    /**
     * Retrieve the {@code extension_mapping_document} property (displayed as '{@literal Extension Mapping Document}') of the object.
     * @return {@code MainObject}
     */
    @JsonProperty("extension_mapping_document")
    public MainObject getExtensionMappingDocument() { return this.extensionMappingDocument; }

    /**
     * Set the {@code extension_mapping_document} property (displayed as {@code Extension Mapping Document}) of the object.
     * @param extensionMappingDocument the value to set
     */
    @JsonProperty("extension_mapping_document")
    public void setExtensionMappingDocument(MainObject extensionMappingDocument) { this.extensionMappingDocument = extensionMappingDocument; }

    /**
     * Retrieve the {@code function} property (displayed as '{@literal Function}') of the object.
     * @return {@code String}
     */
    @JsonProperty("function")
    public String getFunction() { return this.function; }

    /**
     * Set the {@code function} property (displayed as {@code Function}) of the object.
     * @param function the value to set
     */
    @JsonProperty("function")
    public void setFunction(String function) { this.function = function; }

    /**
     * Retrieve the {@code name} property (displayed as '{@literal Name}') of the object.
     * @return {@code String}
     */
    @JsonProperty("name")
    public String getTheName() { return this.name; }

    /**
     * Set the {@code name} property (displayed as {@code Name}) of the object.
     * @param name the value to set
     */
    @JsonProperty("name")
    public void setTheName(String name) { this.name = name; }

    /**
     * Retrieve the {@code native_id} property (displayed as '{@literal Native ID}') of the object.
     * @return {@code String}
     */
    @JsonProperty("native_id")
    public String getNativeId() { return this.nativeId; }

    /**
     * Set the {@code native_id} property (displayed as {@code Native ID}) of the object.
     * @param nativeId the value to set
     */
    @JsonProperty("native_id")
    public void setNativeId(String nativeId) { this.nativeId = nativeId; }

    /**
     * Retrieve the {@code rule} property (displayed as '{@literal Rule}') of the object.
     * @return {@code String}
     */
    @JsonProperty("rule")
    public String getRule() { return this.rule; }

    /**
     * Set the {@code rule} property (displayed as {@code Rule}) of the object.
     * @param rule the value to set
     */
    @JsonProperty("rule")
    public void setRule(String rule) { this.rule = rule; }

    /**
     * Retrieve the {@code sources} property (displayed as '{@literal Sources}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("sources")
    public ItemList<InformationAsset> getSources() { return this.sources; }

    /**
     * Set the {@code sources} property (displayed as {@code Sources}) of the object.
     * @param sources the value to set
     */
    @JsonProperty("sources")
    public void setSources(ItemList<InformationAsset> sources) { this.sources = sources; }

    /**
     * Retrieve the {@code targets} property (displayed as '{@literal Targets}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("targets")
    public ItemList<InformationAsset> getTargets() { return this.targets; }

    /**
     * Set the {@code targets} property (displayed as {@code Targets}) of the object.
     * @param targets the value to set
     */
    @JsonProperty("targets")
    public void setTargets(ItemList<InformationAsset> targets) { this.targets = targets; }

}
