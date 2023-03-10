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
 * POJO for the {@code dsdata_connection} asset type in IGC, displayed as '{@literal Data Connection}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DsdataConnection.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("dsdata_connection")
public class DsdataConnection extends Reference {

    @JsonProperty("connection_string")
    protected String connectionString;

    @JsonProperty("data_connectors")
    protected Connector dataConnectors;

    @JsonProperty("folder_path")
    protected String folderPath;

    @JsonProperty("host")
    protected Host host;

    @JsonProperty("imports_database")
    protected MainObject importsDatabase;

    @JsonProperty("imports_table_definitions")
    protected ItemList<TableDefinition> importsTableDefinitions;

    @JsonProperty("long_description")
    protected String longDescription;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("namespace")
    protected String namespace;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("short_description")
    protected String shortDescription;

    /**
     * Retrieve the {@code connection_string} property (displayed as '{@literal Connection String}') of the object.
     * @return {@code String}
     */
    @JsonProperty("connection_string")
    public String getConnectionString() { return this.connectionString; }

    /**
     * Set the {@code connection_string} property (displayed as {@code Connection String}) of the object.
     * @param connectionString the value to set
     */
    @JsonProperty("connection_string")
    public void setConnectionString(String connectionString) { this.connectionString = connectionString; }

    /**
     * Retrieve the {@code data_connectors} property (displayed as '{@literal Data Connectors}') of the object.
     * @return {@code Connector}
     */
    @JsonProperty("data_connectors")
    public Connector getDataConnectors() { return this.dataConnectors; }

    /**
     * Set the {@code data_connectors} property (displayed as {@code Data Connectors}) of the object.
     * @param dataConnectors the value to set
     */
    @JsonProperty("data_connectors")
    public void setDataConnectors(Connector dataConnectors) { this.dataConnectors = dataConnectors; }

    /**
     * Retrieve the {@code folder_path} property (displayed as '{@literal Folder Path}') of the object.
     * @return {@code String}
     */
    @JsonProperty("folder_path")
    public String getFolderPath() { return this.folderPath; }

    /**
     * Set the {@code folder_path} property (displayed as {@code Folder Path}) of the object.
     * @param folderPath the value to set
     */
    @JsonProperty("folder_path")
    public void setFolderPath(String folderPath) { this.folderPath = folderPath; }

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
     * Retrieve the {@code imports_database} property (displayed as '{@literal Imports Database}') of the object.
     * @return {@code MainObject}
     */
    @JsonProperty("imports_database")
    public MainObject getImportsDatabase() { return this.importsDatabase; }

    /**
     * Set the {@code imports_database} property (displayed as {@code Imports Database}) of the object.
     * @param importsDatabase the value to set
     */
    @JsonProperty("imports_database")
    public void setImportsDatabase(MainObject importsDatabase) { this.importsDatabase = importsDatabase; }

    /**
     * Retrieve the {@code imports_table_definitions} property (displayed as '{@literal Imports Table Definitions}') of the object.
     * @return {@code ItemList<TableDefinition>}
     */
    @JsonProperty("imports_table_definitions")
    public ItemList<TableDefinition> getImportsTableDefinitions() { return this.importsTableDefinitions; }

    /**
     * Set the {@code imports_table_definitions} property (displayed as {@code Imports Table Definitions}) of the object.
     * @param importsTableDefinitions the value to set
     */
    @JsonProperty("imports_table_definitions")
    public void setImportsTableDefinitions(ItemList<TableDefinition> importsTableDefinitions) { this.importsTableDefinitions = importsTableDefinitions; }

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
     * Retrieve the {@code namespace} property (displayed as '{@literal Namespace}') of the object.
     * @return {@code String}
     */
    @JsonProperty("namespace")
    public String getNamespace() { return this.namespace; }

    /**
     * Set the {@code namespace} property (displayed as {@code Namespace}) of the object.
     * @param namespace the value to set
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) { this.namespace = namespace; }

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
