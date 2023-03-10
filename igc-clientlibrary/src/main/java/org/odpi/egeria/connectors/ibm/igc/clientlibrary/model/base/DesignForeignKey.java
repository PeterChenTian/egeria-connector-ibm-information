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
 * POJO for the {@code design_foreign_key} asset type in IGC, displayed as '{@literal Design Foreign Key}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DesignForeignKey.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("design_foreign_key")
public class DesignForeignKey extends Reference {

    @JsonProperty("included_database_columns")
    protected ItemList<DataItem> includedDatabaseColumns;

    @JsonProperty("long_description")
    protected String longDescription;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("of_data_collection")
    protected Datagroup ofDataCollection;

    @JsonProperty("referenced_by_design_column")
    protected ItemList<DataItem> referencedByDesignColumn;

    @JsonProperty("short_description")
    protected String shortDescription;

    /**
     * Retrieve the {@code included_database_columns} property (displayed as '{@literal Design Columns}') of the object.
     * @return {@code ItemList<DataItem>}
     */
    @JsonProperty("included_database_columns")
    public ItemList<DataItem> getIncludedDatabaseColumns() { return this.includedDatabaseColumns; }

    /**
     * Set the {@code included_database_columns} property (displayed as {@code Design Columns}) of the object.
     * @param includedDatabaseColumns the value to set
     */
    @JsonProperty("included_database_columns")
    public void setIncludedDatabaseColumns(ItemList<DataItem> includedDatabaseColumns) { this.includedDatabaseColumns = includedDatabaseColumns; }

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
     * Retrieve the {@code of_data_collection} property (displayed as '{@literal Of Data Collection}') of the object.
     * @return {@code Datagroup}
     */
    @JsonProperty("of_data_collection")
    public Datagroup getOfDataCollection() { return this.ofDataCollection; }

    /**
     * Set the {@code of_data_collection} property (displayed as {@code Of Data Collection}) of the object.
     * @param ofDataCollection the value to set
     */
    @JsonProperty("of_data_collection")
    public void setOfDataCollection(Datagroup ofDataCollection) { this.ofDataCollection = ofDataCollection; }

    /**
     * Retrieve the {@code referenced_by_design_column} property (displayed as '{@literal Parent Design Columns}') of the object.
     * @return {@code ItemList<DataItem>}
     */
    @JsonProperty("referenced_by_design_column")
    public ItemList<DataItem> getReferencedByDesignColumn() { return this.referencedByDesignColumn; }

    /**
     * Set the {@code referenced_by_design_column} property (displayed as {@code Parent Design Columns}) of the object.
     * @param referencedByDesignColumn the value to set
     */
    @JsonProperty("referenced_by_design_column")
    public void setReferencedByDesignColumn(ItemList<DataItem> referencedByDesignColumn) { this.referencedByDesignColumn = referencedByDesignColumn; }

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
