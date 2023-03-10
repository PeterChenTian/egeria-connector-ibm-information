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
import java.util.Date;
import java.util.List;

/**
 * POJO for the {@code database_alias} asset type in IGC, displayed as '{@literal Database Alias}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DatabaseAlias.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("database_alias")
public class DatabaseAlias extends Datagroup {

    @JsonProperty("alias_of_database_tables_or_views")
    protected ItemList<Datagroup> aliasOfDatabaseTablesOrViews;

    @JsonProperty("database_columns")
    protected ItemList<DataItem> databaseColumns;

    @JsonProperty("defined_foreign_key")
    protected ItemList<DatabaseColumn> definedForeignKey;

    /**
     * @deprecated No longer applicable from 11.5.0.2sp5 onwards and 11.7.1.0 onwards.
     * @see #implementedKey
     */
    @Deprecated
    @JsonProperty("defined_primary_key")
    protected ItemList<CandidateKey> definedPrimaryKey;

    @JsonProperty("implemented_key")
    protected ItemList<CandidateKey> implementedKey;

    @JsonProperty("imported_from")
    protected String importedFrom;

    @JsonProperty("indexes")
    protected ItemList<DatabaseIndex> indexes;

    @JsonProperty("lineage_service_information")
    protected List<String> lineageServiceInformation;

    @JsonProperty("lineage_service_last_run_date")
    protected List<Date> lineageServiceLastRunDate;

    @JsonProperty("lineage_service_status")
    protected List<String> lineageServiceStatus;

    @JsonProperty("reads_from_(operational)")
    protected ItemList<InformationAsset> readsFromOperational;

    @JsonProperty("reads_from_(user_defined)")
    protected ItemList<InformationAsset> readsFromUserDefined;

    /**
     * Retrieve the {@code alias_of_database_tables_or_views} property (displayed as '{@literal Alias of Database Tables or Views}') of the object.
     * @return {@code ItemList<Datagroup>}
     */
    @JsonProperty("alias_of_database_tables_or_views")
    public ItemList<Datagroup> getAliasOfDatabaseTablesOrViews() { return this.aliasOfDatabaseTablesOrViews; }

    /**
     * Set the {@code alias_of_database_tables_or_views} property (displayed as {@code Alias of Database Tables or Views}) of the object.
     * @param aliasOfDatabaseTablesOrViews the value to set
     */
    @JsonProperty("alias_of_database_tables_or_views")
    public void setAliasOfDatabaseTablesOrViews(ItemList<Datagroup> aliasOfDatabaseTablesOrViews) { this.aliasOfDatabaseTablesOrViews = aliasOfDatabaseTablesOrViews; }

    /**
     * Retrieve the {@code database_columns} property (displayed as '{@literal Database Columns}') of the object.
     * @return {@code ItemList<DataItem>}
     */
    @JsonProperty("database_columns")
    public ItemList<DataItem> getDatabaseColumns() { return this.databaseColumns; }

    /**
     * Set the {@code database_columns} property (displayed as {@code Database Columns}) of the object.
     * @param databaseColumns the value to set
     */
    @JsonProperty("database_columns")
    public void setDatabaseColumns(ItemList<DataItem> databaseColumns) { this.databaseColumns = databaseColumns; }

    /**
     * Retrieve the {@code defined_foreign_key} property (displayed as '{@literal Defined Foreign Key}') of the object.
     * @return {@code ItemList<DatabaseColumn>}
     */
    @JsonProperty("defined_foreign_key")
    public ItemList<DatabaseColumn> getDefinedForeignKey() { return this.definedForeignKey; }

    /**
     * Set the {@code defined_foreign_key} property (displayed as {@code Defined Foreign Key}) of the object.
     * @param definedForeignKey the value to set
     */
    @JsonProperty("defined_foreign_key")
    public void setDefinedForeignKey(ItemList<DatabaseColumn> definedForeignKey) { this.definedForeignKey = definedForeignKey; }

    /**
     * Retrieve the {@code defined_primary_key} property (displayed as '{@literal Defined Primary Key}') of the object.
     * @deprecated No longer applicable from 11.5.0.2sp5 and 11.7.1.0 onwards.
     * @return {@code ItemList<CandidateKey>}
     * @see #getImplementedKey()
     */
    @Deprecated
    @JsonProperty("defined_primary_key")
    public ItemList<CandidateKey> getDefinedPrimaryKey() { return this.definedPrimaryKey; }

    /**
     * Set the {@code defined_primary_key} property (displayed as {@code Defined Primary Key}) of the object.
     * @deprecated No longer applicable from 11.5.0.2sp5 and 11.7.1.0 onwards.
     * @param definedPrimaryKey the value to set
     * @see #setImplementedKey(ItemList)
     */
    @Deprecated
    @JsonProperty("defined_primary_key")
    public void setDefinedPrimaryKey(ItemList<CandidateKey> definedPrimaryKey) { this.definedPrimaryKey = definedPrimaryKey; }

    /**
     * Retrieve the {@code implemented_key} property (displayed as '{@literal Defined Primary Key}') of the object.
     * @return {@code ItemList<CandidateKey>}
     */
    @JsonProperty("implemented_key")
    public ItemList<CandidateKey> getImplementedKey() { return this.implementedKey; }

    /**
     * Set the {@code implemented_key} property (displayed as {@code Defined Primary Key}) of the object.
     * @param implementedKey the value to set
     */
    @JsonProperty("implemented_key")
    public void setImplementedKey(ItemList<CandidateKey> implementedKey) { this.implementedKey = implementedKey; }

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
     * Retrieve the {@code indexes} property (displayed as '{@literal Indexes}') of the object.
     * @return {@code ItemList<DatabaseIndex>}
     */
    @JsonProperty("indexes")
    public ItemList<DatabaseIndex> getIndexes() { return this.indexes; }

    /**
     * Set the {@code indexes} property (displayed as {@code Indexes}) of the object.
     * @param indexes the value to set
     */
    @JsonProperty("indexes")
    public void setIndexes(ItemList<DatabaseIndex> indexes) { this.indexes = indexes; }

    /**
     * Retrieve the {@code lineage_service_information} property (displayed as '{@literal Lineage Service Information}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("lineage_service_information")
    public List<String> getLineageServiceInformation() { return this.lineageServiceInformation; }

    /**
     * Set the {@code lineage_service_information} property (displayed as {@code Lineage Service Information}) of the object.
     * @param lineageServiceInformation the value to set
     */
    @JsonProperty("lineage_service_information")
    public void setLineageServiceInformation(List<String> lineageServiceInformation) { this.lineageServiceInformation = lineageServiceInformation; }

    /**
     * Retrieve the {@code lineage_service_last_run_date} property (displayed as '{@literal Lineage Service Last Run Date}') of the object.
     * @return {@code List<Date>}
     */
    @JsonProperty("lineage_service_last_run_date")
    public List<Date> getLineageServiceLastRunDate() { return this.lineageServiceLastRunDate; }

    /**
     * Set the {@code lineage_service_last_run_date} property (displayed as {@code Lineage Service Last Run Date}) of the object.
     * @param lineageServiceLastRunDate the value to set
     */
    @JsonProperty("lineage_service_last_run_date")
    public void setLineageServiceLastRunDate(List<Date> lineageServiceLastRunDate) { this.lineageServiceLastRunDate = lineageServiceLastRunDate; }

    /**
     * Retrieve the {@code lineage_service_status} property (displayed as '{@literal Lineage Service Status}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("lineage_service_status")
    public List<String> getLineageServiceStatus() { return this.lineageServiceStatus; }

    /**
     * Set the {@code lineage_service_status} property (displayed as {@code Lineage Service Status}) of the object.
     * @param lineageServiceStatus the value to set
     */
    @JsonProperty("lineage_service_status")
    public void setLineageServiceStatus(List<String> lineageServiceStatus) { this.lineageServiceStatus = lineageServiceStatus; }

    /**
     * Retrieve the {@code reads_from_(operational)} property (displayed as '{@literal Reads from (Operational)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("reads_from_(operational)")
    public ItemList<InformationAsset> getReadsFromOperational() { return this.readsFromOperational; }

    /**
     * Set the {@code reads_from_(operational)} property (displayed as {@code Reads from (Operational)}) of the object.
     * @param readsFromOperational the value to set
     */
    @JsonProperty("reads_from_(operational)")
    public void setReadsFromOperational(ItemList<InformationAsset> readsFromOperational) { this.readsFromOperational = readsFromOperational; }

    /**
     * Retrieve the {@code reads_from_(user_defined)} property (displayed as '{@literal Reads from (User-Defined)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("reads_from_(user_defined)")
    public ItemList<InformationAsset> getReadsFromUserDefined() { return this.readsFromUserDefined; }

    /**
     * Set the {@code reads_from_(user_defined)} property (displayed as {@code Reads from (User-Defined)}) of the object.
     * @param readsFromUserDefined the value to set
     */
    @JsonProperty("reads_from_(user_defined)")
    public void setReadsFromUserDefined(ItemList<InformationAsset> readsFromUserDefined) { this.readsFromUserDefined = readsFromUserDefined; }

}
