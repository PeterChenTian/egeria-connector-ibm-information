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
 * POJO for the {@code tuple_attribute} asset type in IGC, displayed as '{@literal Tuple Attribute}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=TupleAttribute.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("tuple_attribute")
public class TupleAttribute extends InformationAsset {

    /**
     * Valid values are:
     * <ul>
     *   <li>boolean (displayed in the UI as 'boolean')</li>
     *   <li>enum (displayed in the UI as 'enum')</li>
     *   <li>int8 (displayed in the UI as 'int8')</li>
     *   <li>int16 (displayed in the UI as 'int16')</li>
     *   <li>int32 (displayed in the UI as 'int32')</li>
     *   <li>int64 (displayed in the UI as 'int64')</li>
     *   <li>uint8 (displayed in the UI as 'uint8')</li>
     *   <li>uint16 (displayed in the UI as 'uint16')</li>
     *   <li>uint32 (displayed in the UI as 'uint32')</li>
     *   <li>uint64 (displayed in the UI as 'uint64')</li>
     *   <li>float32 (displayed in the UI as 'float32')</li>
     *   <li>float64 (displayed in the UI as 'float64')</li>
     *   <li>decimal32 (displayed in the UI as 'decimal32')</li>
     *   <li>decimal64 (displayed in the UI as 'decimal64')</li>
     *   <li>decimal128 (displayed in the UI as 'decimal128')</li>
     *   <li>complex32 (displayed in the UI as 'complex32')</li>
     *   <li>complex64 (displayed in the UI as 'complex64')</li>
     *   <li>timestamp (displayed in the UI as 'timestamp')</li>
     *   <li>rstring (displayed in the UI as 'rstring')</li>
     *   <li>ustring (displayed in the UI as 'ustring')</li>
     *   <li>blob (displayed in the UI as 'blob')</li>
     *   <li>xml (displayed in the UI as 'xml')</li>
     *   <li>tuple (displayed in the UI as 'tuple')</li>
     *   <li>list (displayed in the UI as 'list')</li>
     *   <li>set (displayed in the UI as 'set')</li>
     *   <li>map (displayed in the UI as 'map')</li>
     * </ul>
     */
    @JsonProperty("collection_type")
    protected String collectionType;

    @JsonProperty("length")
    protected Number length;

    @JsonProperty("tuple")
    protected RootTuple tuple;

    @JsonProperty("tuple_attribute")
    protected ItemList<TupleAttribute> tupleAttribute;

    @JsonProperty("tuple_or_tuple_attribute")
    protected ItemList<MainObject> tupleOrTupleAttribute;

    /**
     * Valid values are:
     * <ul>
     *   <li>boolean (displayed in the UI as 'boolean')</li>
     *   <li>enum (displayed in the UI as 'enum')</li>
     *   <li>int8 (displayed in the UI as 'int8')</li>
     *   <li>int16 (displayed in the UI as 'int16')</li>
     *   <li>int32 (displayed in the UI as 'int32')</li>
     *   <li>int64 (displayed in the UI as 'int64')</li>
     *   <li>uint8 (displayed in the UI as 'uint8')</li>
     *   <li>uint16 (displayed in the UI as 'uint16')</li>
     *   <li>uint32 (displayed in the UI as 'uint32')</li>
     *   <li>uint64 (displayed in the UI as 'uint64')</li>
     *   <li>float32 (displayed in the UI as 'float32')</li>
     *   <li>float64 (displayed in the UI as 'float64')</li>
     *   <li>decimal32 (displayed in the UI as 'decimal32')</li>
     *   <li>decimal64 (displayed in the UI as 'decimal64')</li>
     *   <li>decimal128 (displayed in the UI as 'decimal128')</li>
     *   <li>complex32 (displayed in the UI as 'complex32')</li>
     *   <li>complex64 (displayed in the UI as 'complex64')</li>
     *   <li>timestamp (displayed in the UI as 'timestamp')</li>
     *   <li>rstring (displayed in the UI as 'rstring')</li>
     *   <li>ustring (displayed in the UI as 'ustring')</li>
     *   <li>blob (displayed in the UI as 'blob')</li>
     *   <li>xml (displayed in the UI as 'xml')</li>
     *   <li>tuple (displayed in the UI as 'tuple')</li>
     *   <li>list (displayed in the UI as 'list')</li>
     *   <li>set (displayed in the UI as 'set')</li>
     *   <li>map (displayed in the UI as 'map')</li>
     * </ul>
     */
    @JsonProperty("type")
    protected String type;

    /**
     * Retrieve the {@code collection_type} property (displayed as '{@literal Collection Type}') of the object.
     * @return {@code String}
     */
    @JsonProperty("collection_type")
    public String getCollectionType() { return this.collectionType; }

    /**
     * Set the {@code collection_type} property (displayed as {@code Collection Type}) of the object.
     * @param collectionType the value to set
     */
    @JsonProperty("collection_type")
    public void setCollectionType(String collectionType) { this.collectionType = collectionType; }

    /**
     * Retrieve the {@code length} property (displayed as '{@literal Length}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("length")
    public Number getLength() { return this.length; }

    /**
     * Set the {@code length} property (displayed as {@code Length}) of the object.
     * @param length the value to set
     */
    @JsonProperty("length")
    public void setLength(Number length) { this.length = length; }

    /**
     * Retrieve the {@code tuple} property (displayed as '{@literal Tuple}') of the object.
     * @return {@code RootTuple}
     */
    @JsonProperty("tuple")
    public RootTuple getTuple() { return this.tuple; }

    /**
     * Set the {@code tuple} property (displayed as {@code Tuple}) of the object.
     * @param tuple the value to set
     */
    @JsonProperty("tuple")
    public void setTuple(RootTuple tuple) { this.tuple = tuple; }

    /**
     * Retrieve the {@code tuple_attribute} property (displayed as '{@literal Tuple Attribute}') of the object.
     * @return {@code ItemList<TupleAttribute>}
     */
    @JsonProperty("tuple_attribute")
    public ItemList<TupleAttribute> getTupleAttribute() { return this.tupleAttribute; }

    /**
     * Set the {@code tuple_attribute} property (displayed as {@code Tuple Attribute}) of the object.
     * @param tupleAttribute the value to set
     */
    @JsonProperty("tuple_attribute")
    public void setTupleAttribute(ItemList<TupleAttribute> tupleAttribute) { this.tupleAttribute = tupleAttribute; }

    /**
     * Retrieve the {@code tuple_or_tuple_attribute} property (displayed as '{@literal Tuple or Tuple Attribute}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("tuple_or_tuple_attribute")
    public ItemList<MainObject> getTupleOrTupleAttribute() { return this.tupleOrTupleAttribute; }

    /**
     * Set the {@code tuple_or_tuple_attribute} property (displayed as {@code Tuple or Tuple Attribute}) of the object.
     * @param tupleOrTupleAttribute the value to set
     */
    @JsonProperty("tuple_or_tuple_attribute")
    public void setTupleOrTupleAttribute(ItemList<MainObject> tupleOrTupleAttribute) { this.tupleOrTupleAttribute = tupleOrTupleAttribute; }

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
