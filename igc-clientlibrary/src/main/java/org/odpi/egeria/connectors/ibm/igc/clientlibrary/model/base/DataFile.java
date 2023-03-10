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
 * POJO for the {@code data_file} asset type in IGC, displayed as '{@literal Data File}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DataFile.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("data_file")
public class DataFile extends InformationAsset {

    @JsonProperty("alias_(business_name)")
    protected String aliasBusinessName;

    @JsonProperty("amazon_s3_data_files")
    protected AmazonS3DataFile amazonS3DataFiles;

    @JsonProperty("data_file_records")
    protected ItemList<DataFileRecord> dataFileRecords;

    @JsonProperty("host")
    protected Host host;

    @JsonProperty("implements_data_file_definition")
    protected DataFileDefinition implementsDataFileDefinition;

    @JsonProperty("implements_physical_models")
    protected ItemList<PhysicalDataModel> implementsPhysicalModels;

    @JsonProperty("imported_from")
    protected String importedFrom;

    @JsonProperty("include_for_business_lineage")
    protected Boolean includeForBusinessLineage;

    @JsonProperty("parent_folder")
    protected MainObject parentFolder;

    @JsonProperty("parent_folder_or_host")
    protected ItemList<MainObject> parentFolderOrHost;

    @JsonProperty("path")
    protected String path;

    @JsonProperty("store_type")
    protected String storeType;

    /**
     * @deprecated No longer applicable from 11.7.1.1 onwards.
     */
    @Deprecated
    @JsonProperty("suggested_term_assignments")
    protected ItemList<TermAssignment> suggestedTermAssignments;

    @JsonProperty("synchronized_from")
    protected String synchronizedFrom;

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
     * Retrieve the {@code amazon_s3_data_files} property (displayed as '{@literal Amazon S3 Data Files}') of the object.
     * @return {@code AmazonS3DataFile}
     */
    @JsonProperty("amazon_s3_data_files")
    public AmazonS3DataFile getAmazonS3DataFiles() { return this.amazonS3DataFiles; }

    /**
     * Set the {@code amazon_s3_data_files} property (displayed as {@code Amazon S3 Data Files}) of the object.
     * @param amazonS3DataFiles the value to set
     */
    @JsonProperty("amazon_s3_data_files")
    public void setAmazonS3DataFiles(AmazonS3DataFile amazonS3DataFiles) { this.amazonS3DataFiles = amazonS3DataFiles; }

    /**
     * Retrieve the {@code data_file_records} property (displayed as '{@literal Data File Records}') of the object.
     * @return {@code ItemList<DataFileRecord>}
     */
    @JsonProperty("data_file_records")
    public ItemList<DataFileRecord> getDataFileRecords() { return this.dataFileRecords; }

    /**
     * Set the {@code data_file_records} property (displayed as {@code Data File Records}) of the object.
     * @param dataFileRecords the value to set
     */
    @JsonProperty("data_file_records")
    public void setDataFileRecords(ItemList<DataFileRecord> dataFileRecords) { this.dataFileRecords = dataFileRecords; }

    /**
     * Retrieve the {@code host} property (displayed as '{@literal Host}') of the object.
     * @return {@code Host}
     */
    @JsonProperty("host")
    public Host getHost() { return this.host; }

    /**
     * Set the {@code host} property (displayed as {@code Host}) of the object.
     * @param host the value to set
     */
    @JsonProperty("host")
    public void setHost(Host host) { this.host = host; }

    /**
     * Retrieve the {@code implements_data_file_definition} property (displayed as '{@literal Implements Data File Definition}') of the object.
     * @return {@code DataFileDefinition}
     */
    @JsonProperty("implements_data_file_definition")
    public DataFileDefinition getImplementsDataFileDefinition() { return this.implementsDataFileDefinition; }

    /**
     * Set the {@code implements_data_file_definition} property (displayed as {@code Implements Data File Definition}) of the object.
     * @param implementsDataFileDefinition the value to set
     */
    @JsonProperty("implements_data_file_definition")
    public void setImplementsDataFileDefinition(DataFileDefinition implementsDataFileDefinition) { this.implementsDataFileDefinition = implementsDataFileDefinition; }

    /**
     * Retrieve the {@code implements_physical_models} property (displayed as '{@literal Implements Physical Models}') of the object.
     * @return {@code ItemList<PhysicalDataModel>}
     */
    @JsonProperty("implements_physical_models")
    public ItemList<PhysicalDataModel> getImplementsPhysicalModels() { return this.implementsPhysicalModels; }

    /**
     * Set the {@code implements_physical_models} property (displayed as {@code Implements Physical Models}) of the object.
     * @param implementsPhysicalModels the value to set
     */
    @JsonProperty("implements_physical_models")
    public void setImplementsPhysicalModels(ItemList<PhysicalDataModel> implementsPhysicalModels) { this.implementsPhysicalModels = implementsPhysicalModels; }

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
     * Retrieve the {@code include_for_business_lineage} property (displayed as '{@literal Include for Business Lineage}') of the object.
     * @return {@code Boolean}
     */
    @JsonProperty("include_for_business_lineage")
    public Boolean getIncludeForBusinessLineage() { return this.includeForBusinessLineage; }

    /**
     * Set the {@code include_for_business_lineage} property (displayed as {@code Include for Business Lineage}) of the object.
     * @param includeForBusinessLineage the value to set
     */
    @JsonProperty("include_for_business_lineage")
    public void setIncludeForBusinessLineage(Boolean includeForBusinessLineage) { this.includeForBusinessLineage = includeForBusinessLineage; }

    /**
     * Retrieve the {@code parent_folder} property (displayed as '{@literal Parent Folder}') of the object.
     * @return {@code MainObject}
     */
    @JsonProperty("parent_folder")
    public MainObject getParentFolder() { return this.parentFolder; }

    /**
     * Set the {@code parent_folder} property (displayed as {@code Parent Folder}) of the object.
     * @param parentFolder the value to set
     */
    @JsonProperty("parent_folder")
    public void setParentFolder(MainObject parentFolder) { this.parentFolder = parentFolder; }

    /**
     * Retrieve the {@code parent_folder_or_host} property (displayed as '{@literal Parent Folder or Host}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("parent_folder_or_host")
    public ItemList<MainObject> getParentFolderOrHost() { return this.parentFolderOrHost; }

    /**
     * Set the {@code parent_folder_or_host} property (displayed as {@code Parent Folder or Host}) of the object.
     * @param parentFolderOrHost the value to set
     */
    @JsonProperty("parent_folder_or_host")
    public void setParentFolderOrHost(ItemList<MainObject> parentFolderOrHost) { this.parentFolderOrHost = parentFolderOrHost; }

    /**
     * Retrieve the {@code path} property (displayed as '{@literal Path}') of the object.
     * @return {@code String}
     */
    @JsonProperty("path")
    public String getPath() { return this.path; }

    /**
     * Set the {@code path} property (displayed as {@code Path}) of the object.
     * @param path the value to set
     */
    @JsonProperty("path")
    public void setPath(String path) { this.path = path; }

    /**
     * Retrieve the {@code store_type} property (displayed as '{@literal Type}') of the object.
     * @return {@code String}
     */
    @JsonProperty("store_type")
    public String getStoreType() { return this.storeType; }

    /**
     * Set the {@code store_type} property (displayed as {@code Type}) of the object.
     * @param storeType the value to set
     */
    @JsonProperty("store_type")
    public void setStoreType(String storeType) { this.storeType = storeType; }

    /**
     * Retrieve the {@code suggested_term_assignments} property (displayed as '{@literal Suggested Term Assignments}') of the object.
     * @deprecated No longer applicable from 11.7.1.1 onwards.
     * @return {@code ItemList<TermAssignment>}
     */
    @Deprecated
    @JsonProperty("suggested_term_assignments")
    public ItemList<TermAssignment> getSuggestedTermAssignments() { return this.suggestedTermAssignments; }

    /**
     * Set the {@code suggested_term_assignments} property (displayed as {@code Suggested Term Assignments}) of the object.
     * @deprecated No longer applicable from 11.7.1.1 onwards.
     * @param suggestedTermAssignments the value to set
     */
    @Deprecated
    @JsonProperty("suggested_term_assignments")
    public void setSuggestedTermAssignments(ItemList<TermAssignment> suggestedTermAssignments) { this.suggestedTermAssignments = suggestedTermAssignments; }

    /**
     * Retrieve the {@code synchronized_from} property (displayed as '{@literal Synchronized From}') of the object.
     * @return {@code String}
     */
    @JsonProperty("synchronized_from")
    public String getSynchronizedFrom() { return this.synchronizedFrom; }

    /**
     * Set the {@code synchronized_from} property (displayed as {@code Synchronized From}) of the object.
     * @param synchronizedFrom the value to set
     */
    @JsonProperty("synchronized_from")
    public void setSynchronizedFrom(String synchronizedFrom) { this.synchronizedFrom = synchronizedFrom; }

}
