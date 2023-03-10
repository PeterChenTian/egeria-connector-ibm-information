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
 * POJO for the {@code design_table} asset type in IGC, displayed as '{@literal Design Table}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DesignTable.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("design_table")
public class DesignTable extends Datagroup {

    @JsonProperty("alias_(business_name)")
    protected String aliasBusinessName;

    @JsonProperty("design_columns")
    protected ItemList<DesignColumn> designColumns;

    @JsonProperty("design_foreign_keys")
    protected ItemList<DesignForeignKey> designForeignKeys;

    @JsonProperty("design_keys")
    protected ItemList<DesignKey> designKeys;

    @JsonProperty("implemented_by_data_file_elements")
    protected ItemList<DataFileRecord> implementedByDataFileElements;

    @JsonProperty("implemented_by_database_tables_views")
    protected ItemList<Datagroup> implementedByDatabaseTablesViews;

    @JsonProperty("implements_logical_entities")
    protected ItemList<LogicalEntity> implementsLogicalEntities;

    @JsonProperty("imported_from")
    protected String importedFrom;

    @JsonProperty("physical_data_model")
    protected PhysicalDataModel physicalDataModel;

    @JsonProperty("referenced_by_design_foreign_keys")
    protected ItemList<DesignForeignKey> referencedByDesignForeignKeys;

    /**
     * Retrieve the {@code alias_(business_name)} property (displayed as '{@literal Alias (Business Name)}') of the object.
     * @return {@code String}
     */
    @JsonProperty("alias_(business_name)")
    public String getAliasBusinessName() { return this.aliasBusinessName; }

    /**
     * Set the {@code alias_(business_name)} property (displayed as {@code Alias (Business Name)}) of the object.
     * @param aliasBusinessName the value to set
     */
    @JsonProperty("alias_(business_name)")
    public void setAliasBusinessName(String aliasBusinessName) { this.aliasBusinessName = aliasBusinessName; }

    /**
     * Retrieve the {@code design_columns} property (displayed as '{@literal Design Columns}') of the object.
     * @return {@code ItemList<DesignColumn>}
     */
    @JsonProperty("design_columns")
    public ItemList<DesignColumn> getDesignColumns() { return this.designColumns; }

    /**
     * Set the {@code design_columns} property (displayed as {@code Design Columns}) of the object.
     * @param designColumns the value to set
     */
    @JsonProperty("design_columns")
    public void setDesignColumns(ItemList<DesignColumn> designColumns) { this.designColumns = designColumns; }

    /**
     * Retrieve the {@code design_foreign_keys} property (displayed as '{@literal Parent Design Foreign Keys}') of the object.
     * @return {@code ItemList<DesignForeignKey>}
     */
    @JsonProperty("design_foreign_keys")
    public ItemList<DesignForeignKey> getDesignForeignKeys() { return this.designForeignKeys; }

    /**
     * Set the {@code design_foreign_keys} property (displayed as {@code Parent Design Foreign Keys}) of the object.
     * @param designForeignKeys the value to set
     */
    @JsonProperty("design_foreign_keys")
    public void setDesignForeignKeys(ItemList<DesignForeignKey> designForeignKeys) { this.designForeignKeys = designForeignKeys; }

    /**
     * Retrieve the {@code design_keys} property (displayed as '{@literal Design Keys}') of the object.
     * @return {@code ItemList<DesignKey>}
     */
    @JsonProperty("design_keys")
    public ItemList<DesignKey> getDesignKeys() { return this.designKeys; }

    /**
     * Set the {@code design_keys} property (displayed as {@code Design Keys}) of the object.
     * @param designKeys the value to set
     */
    @JsonProperty("design_keys")
    public void setDesignKeys(ItemList<DesignKey> designKeys) { this.designKeys = designKeys; }

    /**
     * Retrieve the {@code implemented_by_data_file_elements} property (displayed as '{@literal Implemented by Data File Records}') of the object.
     * @return {@code ItemList<DataFileRecord>}
     */
    @JsonProperty("implemented_by_data_file_elements")
    public ItemList<DataFileRecord> getImplementedByDataFileElements() { return this.implementedByDataFileElements; }

    /**
     * Set the {@code implemented_by_data_file_elements} property (displayed as {@code Implemented by Data File Records}) of the object.
     * @param implementedByDataFileElements the value to set
     */
    @JsonProperty("implemented_by_data_file_elements")
    public void setImplementedByDataFileElements(ItemList<DataFileRecord> implementedByDataFileElements) { this.implementedByDataFileElements = implementedByDataFileElements; }

    /**
     * Retrieve the {@code implemented_by_database_tables_views} property (displayed as '{@literal Implemented by Database Tables or Views}') of the object.
     * @return {@code ItemList<Datagroup>}
     */
    @JsonProperty("implemented_by_database_tables_views")
    public ItemList<Datagroup> getImplementedByDatabaseTablesViews() { return this.implementedByDatabaseTablesViews; }

    /**
     * Set the {@code implemented_by_database_tables_views} property (displayed as {@code Implemented by Database Tables or Views}) of the object.
     * @param implementedByDatabaseTablesViews the value to set
     */
    @JsonProperty("implemented_by_database_tables_views")
    public void setImplementedByDatabaseTablesViews(ItemList<Datagroup> implementedByDatabaseTablesViews) { this.implementedByDatabaseTablesViews = implementedByDatabaseTablesViews; }

    /**
     * Retrieve the {@code implements_logical_entities} property (displayed as '{@literal Implements Logical Entities}') of the object.
     * @return {@code ItemList<LogicalEntity>}
     */
    @JsonProperty("implements_logical_entities")
    public ItemList<LogicalEntity> getImplementsLogicalEntities() { return this.implementsLogicalEntities; }

    /**
     * Set the {@code implements_logical_entities} property (displayed as {@code Implements Logical Entities}) of the object.
     * @param implementsLogicalEntities the value to set
     */
    @JsonProperty("implements_logical_entities")
    public void setImplementsLogicalEntities(ItemList<LogicalEntity> implementsLogicalEntities) { this.implementsLogicalEntities = implementsLogicalEntities; }

    /**
     * Retrieve the {@code imported_from} property (displayed as '{@literal Imported From}') of the object.
     * @return {@code String}
     */
    @JsonProperty("imported_from")
    public String getImportedFrom() { return this.importedFrom; }

    /**
     * Set the {@code imported_from} property (displayed as {@code Imported From}) of the object.
     * @param importedFrom the value to set
     */
    @JsonProperty("imported_from")
    public void setImportedFrom(String importedFrom) { this.importedFrom = importedFrom; }

    /**
     * Retrieve the {@code physical_data_model} property (displayed as '{@literal Physical Data Model}') of the object.
     * @return {@code PhysicalDataModel}
     */
    @JsonProperty("physical_data_model")
    public PhysicalDataModel getPhysicalDataModel() { return this.physicalDataModel; }

    /**
     * Set the {@code physical_data_model} property (displayed as {@code Physical Data Model}) of the object.
     * @param physicalDataModel the value to set
     */
    @JsonProperty("physical_data_model")
    public void setPhysicalDataModel(PhysicalDataModel physicalDataModel) { this.physicalDataModel = physicalDataModel; }

    /**
     * Retrieve the {@code referenced_by_design_foreign_keys} property (displayed as '{@literal Child Design Foreign Keys}') of the object.
     * @return {@code ItemList<DesignForeignKey>}
     */
    @JsonProperty("referenced_by_design_foreign_keys")
    public ItemList<DesignForeignKey> getReferencedByDesignForeignKeys() { return this.referencedByDesignForeignKeys; }

    /**
     * Set the {@code referenced_by_design_foreign_keys} property (displayed as {@code Child Design Foreign Keys}) of the object.
     * @param referencedByDesignForeignKeys the value to set
     */
    @JsonProperty("referenced_by_design_foreign_keys")
    public void setReferencedByDesignForeignKeys(ItemList<DesignForeignKey> referencedByDesignForeignKeys) { this.referencedByDesignForeignKeys = referencedByDesignForeignKeys; }

}
