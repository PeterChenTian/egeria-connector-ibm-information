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

/**
 * POJO for the {@code dsparameter_set} asset type in IGC, displayed as '{@literal Parameter}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DsparameterSet.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("dsparameter_set")
public class DsparameterSet extends Reference {

    @JsonProperty("default_value")
    protected String defaultValue;

    @JsonProperty("display_caption")
    protected String displayCaption;

    @JsonProperty("help_text")
    protected String helpText;

    @JsonProperty("long_description")
    protected String longDescription;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("of_parameter_set")
    protected ParameterSet2 ofParameterSet;

    @JsonProperty("short_description")
    protected String shortDescription;

    /**
     * Valid values are:
     * <ul>
     *   <li>UNUSED (displayed in the UI as 'UNUSED')</li>
     *   <li>ENCRYPTED (displayed in the UI as 'ENCRYPTED')</li>
     *   <li>PATHNAME (displayed in the UI as 'PATHNAME')</li>
     *   <li>STRINGLIST (displayed in the UI as 'STRINGLIST')</li>
     *   <li>INPUTCOL (displayed in the UI as 'INPUTCOL')</li>
     *   <li>OUTPUTCOL (displayed in the UI as 'OUTPUTCOL')</li>
     *   <li>NCHAR (displayed in the UI as 'NCHAR')</li>
     *   <li>PARAMETERSET (displayed in the UI as 'PARAMETERSET')</li>
     * </ul>
     */
    @JsonProperty("type")
    protected String type;

    /**
     * Retrieve the {@code default_value} property (displayed as '{@literal Default Value}') of the object.
     * @return {@code String}
     */
    @JsonProperty("default_value")
    public String getDefaultValue() { return this.defaultValue; }

    /**
     * Set the {@code default_value} property (displayed as {@code Default Value}) of the object.
     * @param defaultValue the value to set
     */
    @JsonProperty("default_value")
    public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }

    /**
     * Retrieve the {@code display_caption} property (displayed as '{@literal Display Caption}') of the object.
     * @return {@code String}
     */
    @JsonProperty("display_caption")
    public String getDisplayCaption() { return this.displayCaption; }

    /**
     * Set the {@code display_caption} property (displayed as {@code Display Caption}) of the object.
     * @param displayCaption the value to set
     */
    @JsonProperty("display_caption")
    public void setDisplayCaption(String displayCaption) { this.displayCaption = displayCaption; }

    /**
     * Retrieve the {@code help_text} property (displayed as '{@literal Help Text}') of the object.
     * @return {@code String}
     */
    @JsonProperty("help_text")
    public String getHelpText() { return this.helpText; }

    /**
     * Set the {@code help_text} property (displayed as {@code Help Text}) of the object.
     * @param helpText the value to set
     */
    @JsonProperty("help_text")
    public void setHelpText(String helpText) { this.helpText = helpText; }

    /**
     * Retrieve the {@code long_description} property (displayed as '{@literal Long Description}') of the object.
     * @return {@code String}
     */
    @JsonProperty("long_description")
    public String getLongDescription() { return this.longDescription; }

    /**
     * Set the {@code long_description} property (displayed as {@code Long Description}) of the object.
     * @param longDescription the value to set
     */
    @JsonProperty("long_description")
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

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
     * Retrieve the {@code of_parameter_set} property (displayed as '{@literal Context}') of the object.
     * @return {@code ParameterSet2}
     */
    @JsonProperty("of_parameter_set")
    public ParameterSet2 getOfParameterSet() { return this.ofParameterSet; }

    /**
     * Set the {@code of_parameter_set} property (displayed as {@code Context}) of the object.
     * @param ofParameterSet the value to set
     */
    @JsonProperty("of_parameter_set")
    public void setOfParameterSet(ParameterSet2 ofParameterSet) { this.ofParameterSet = ofParameterSet; }

    /**
     * Retrieve the {@code short_description} property (displayed as '{@literal Short Description}') of the object.
     * @return {@code String}
     */
    @JsonProperty("short_description")
    public String getShortDescription() { return this.shortDescription; }

    /**
     * Set the {@code short_description} property (displayed as {@code Short Description}) of the object.
     * @param shortDescription the value to set
     */
    @JsonProperty("short_description")
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

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

}
