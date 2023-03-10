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
import java.util.Date;

/**
 * POJO for the {@code customattributedef} asset type in IGC, displayed as '{@literal CustomAttributeDef}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=Customattributedef.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("customattributedef")
public class Customattributedef extends InformationAsset {

    @JsonProperty("data_type")
    protected String dataType;

    @JsonProperty("description")
    protected String description;

    @JsonProperty("has_custom_attribute_val")
    protected ItemList<Customattributeval> hasCustomAttributeVal;

    @JsonProperty("has_data_values")
    protected DataItemValue hasDataValues;

    @JsonProperty("has_valid_values")
    protected Validvalues hasValidValues;

    @JsonProperty("of_class_descriptor")
    protected Classdescriptor ofClassDescriptor;

    /**
     * Retrieve the {@code data_type} property (displayed as '{@literal Data Type}') of the object.
     * @return {@code String}
     */
    @JsonProperty("data_type")
    public String getDataType() { return this.dataType; }

    /**
     * Set the {@code data_type} property (displayed as {@code Data Type}) of the object.
     * @param dataType the value to set
     */
    @JsonProperty("data_type")
    public void setDataType(String dataType) { this.dataType = dataType; }

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
     * Retrieve the {@code has_custom_attribute_val} property (displayed as '{@literal Has Custom Attribute Val}') of the object.
     * @return {@code ItemList<Customattributeval>}
     */
    @JsonProperty("has_custom_attribute_val")
    public ItemList<Customattributeval> getHasCustomAttributeVal() { return this.hasCustomAttributeVal; }

    /**
     * Set the {@code has_custom_attribute_val} property (displayed as {@code Has Custom Attribute Val}) of the object.
     * @param hasCustomAttributeVal the value to set
     */
    @JsonProperty("has_custom_attribute_val")
    public void setHasCustomAttributeVal(ItemList<Customattributeval> hasCustomAttributeVal) { this.hasCustomAttributeVal = hasCustomAttributeVal; }

    /**
     * Retrieve the {@code has_data_values} property (displayed as '{@literal Has Data Values}') of the object.
     * @return {@code DataItemValue}
     */
    @JsonProperty("has_data_values")
    public DataItemValue getHasDataValues() { return this.hasDataValues; }

    /**
     * Set the {@code has_data_values} property (displayed as {@code Has Data Values}) of the object.
     * @param hasDataValues the value to set
     */
    @JsonProperty("has_data_values")
    public void setHasDataValues(DataItemValue hasDataValues) { this.hasDataValues = hasDataValues; }

    /**
     * Retrieve the {@code has_valid_values} property (displayed as '{@literal Has Valid Values}') of the object.
     * @return {@code Validvalues}
     */
    @JsonProperty("has_valid_values")
    public Validvalues getHasValidValues() { return this.hasValidValues; }

    /**
     * Set the {@code has_valid_values} property (displayed as {@code Has Valid Values}) of the object.
     * @param hasValidValues the value to set
     */
    @JsonProperty("has_valid_values")
    public void setHasValidValues(Validvalues hasValidValues) { this.hasValidValues = hasValidValues; }

    /**
     * Retrieve the {@code of_class_descriptor} property (displayed as '{@literal Of Class Descriptor}') of the object.
     * @return {@code Classdescriptor}
     */
    @JsonProperty("of_class_descriptor")
    public Classdescriptor getOfClassDescriptor() { return this.ofClassDescriptor; }

    /**
     * Set the {@code of_class_descriptor} property (displayed as {@code Of Class Descriptor}) of the object.
     * @param ofClassDescriptor the value to set
     */
    @JsonProperty("of_class_descriptor")
    public void setOfClassDescriptor(Classdescriptor ofClassDescriptor) { this.ofClassDescriptor = ofClassDescriptor; }

}
