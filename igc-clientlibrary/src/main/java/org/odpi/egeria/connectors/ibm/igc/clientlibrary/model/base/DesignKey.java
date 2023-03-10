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
 * POJO for the {@code design_key} asset type in IGC, displayed as '{@literal Design Key}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DesignKey.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("design_key")
public class DesignKey extends Reference {

    @JsonProperty("defined_on_design_columns")
    protected ItemList<DataItem> definedOnDesignColumns;

    @JsonProperty("design_table_or_view")
    protected Datagroup designTableOrView;

    @JsonProperty("long_description")
    protected String longDescription;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("primary_key")
    protected Boolean primaryKey;

    @JsonProperty("referenced_by_design_foreign_keys")
    protected ItemList<ForeignKey> referencedByDesignForeignKeys;

    @JsonProperty("short_description")
    protected String shortDescription;

    /**
     * Retrieve the {@code defined_on_design_columns} property (displayed as '{@literal Design Columns}') of the object.
     * @return {@code ItemList<DataItem>}
     */
    @JsonProperty("defined_on_design_columns")
    public ItemList<DataItem> getDefinedOnDesignColumns() { return this.definedOnDesignColumns; }

    /**
     * Set the {@code defined_on_design_columns} property (displayed as {@code Design Columns}) of the object.
     * @param definedOnDesignColumns the value to set
     */
    @JsonProperty("defined_on_design_columns")
    public void setDefinedOnDesignColumns(ItemList<DataItem> definedOnDesignColumns) { this.definedOnDesignColumns = definedOnDesignColumns; }

    /**
     * Retrieve the {@code design_table_or_view} property (displayed as '{@literal Design Table or View}') of the object.
     * @return {@code Datagroup}
     */
    @JsonProperty("design_table_or_view")
    public Datagroup getDesignTableOrView() { return this.designTableOrView; }

    /**
     * Set the {@code design_table_or_view} property (displayed as {@code Design Table or View}) of the object.
     * @param designTableOrView the value to set
     */
    @JsonProperty("design_table_or_view")
    public void setDesignTableOrView(Datagroup designTableOrView) { this.designTableOrView = designTableOrView; }

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
     * Retrieve the {@code primary_key} property (displayed as '{@literal Primary Key}') of the object.
     * @return {@code Boolean}
     */
    @JsonProperty("primary_key")
    public Boolean getPrimaryKey() { return this.primaryKey; }

    /**
     * Set the {@code primary_key} property (displayed as {@code Primary Key}) of the object.
     * @param primaryKey the value to set
     */
    @JsonProperty("primary_key")
    public void setPrimaryKey(Boolean primaryKey) { this.primaryKey = primaryKey; }

    /**
     * Retrieve the {@code referenced_by_design_foreign_keys} property (displayed as '{@literal Child Design Foreign Keys}') of the object.
     * @return {@code ItemList<ForeignKey>}
     */
    @JsonProperty("referenced_by_design_foreign_keys")
    public ItemList<ForeignKey> getReferencedByDesignForeignKeys() { return this.referencedByDesignForeignKeys; }

    /**
     * Set the {@code referenced_by_design_foreign_keys} property (displayed as {@code Child Design Foreign Keys}) of the object.
     * @param referencedByDesignForeignKeys the value to set
     */
    @JsonProperty("referenced_by_design_foreign_keys")
    public void setReferencedByDesignForeignKeys(ItemList<ForeignKey> referencedByDesignForeignKeys) { this.referencedByDesignForeignKeys = referencedByDesignForeignKeys; }

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

}
