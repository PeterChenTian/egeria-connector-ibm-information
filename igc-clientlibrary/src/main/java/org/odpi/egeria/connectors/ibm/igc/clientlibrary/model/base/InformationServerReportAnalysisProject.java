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
import java.util.List;

/**
 * POJO for the {@code information_server_report_(analysis_project)} asset type in IGC, displayed as '{@literal Information Server Report (Analysis Project)}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=InformationServerReportAnalysisProject.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("information_server_report_(analysis_project)")
public class InformationServerReportAnalysisProject extends Reference {

    @JsonProperty("analysis_project")
    protected List<String> analysisProject;

    @JsonProperty("creator")
    protected String creator;

    @JsonProperty("database")
    protected List<String> database;

    @JsonProperty("description")
    protected String description;

    @JsonProperty("host")
    protected List<String> host;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("product")
    protected String product;

    @JsonProperty("schema")
    protected List<String> schema;

    @JsonProperty("table")
    protected List<String> table;

    /**
     * Retrieve the {@code analysis_project} property (displayed as '{@literal Analysis Project}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("analysis_project")
    public List<String> getAnalysisProject() { return this.analysisProject; }

    /**
     * Set the {@code analysis_project} property (displayed as {@code Analysis Project}) of the object.
     * @param analysisProject the value to set
     */
    @JsonProperty("analysis_project")
    public void setAnalysisProject(List<String> analysisProject) { this.analysisProject = analysisProject; }

    /**
     * Retrieve the {@code creator} property (displayed as '{@literal Creator}') of the object.
     * @return {@code String}
     */
    @JsonProperty("creator")
    public String getCreator() { return this.creator; }

    /**
     * Set the {@code creator} property (displayed as {@code Creator}) of the object.
     * @param creator the value to set
     */
    @JsonProperty("creator")
    public void setCreator(String creator) { this.creator = creator; }

    /**
     * Retrieve the {@code database} property (displayed as '{@literal Database}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("database")
    public List<String> getDatabase() { return this.database; }

    /**
     * Set the {@code database} property (displayed as {@code Database}) of the object.
     * @param database the value to set
     */
    @JsonProperty("database")
    public void setDatabase(List<String> database) { this.database = database; }

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
     * Retrieve the {@code host} property (displayed as '{@literal Host}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("host")
    public List<String> getHost() { return this.host; }

    /**
     * Set the {@code host} property (displayed as {@code Host}) of the object.
     * @param host the value to set
     */
    @JsonProperty("host")
    public void setHost(List<String> host) { this.host = host; }

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
     * Retrieve the {@code product} property (displayed as '{@literal Product}') of the object.
     * @return {@code String}
     */
    @JsonProperty("product")
    public String getProduct() { return this.product; }

    /**
     * Set the {@code product} property (displayed as {@code Product}) of the object.
     * @param product the value to set
     */
    @JsonProperty("product")
    public void setProduct(String product) { this.product = product; }

    /**
     * Retrieve the {@code schema} property (displayed as '{@literal Schema}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("schema")
    public List<String> getSchema() { return this.schema; }

    /**
     * Set the {@code schema} property (displayed as {@code Schema}) of the object.
     * @param schema the value to set
     */
    @JsonProperty("schema")
    public void setSchema(List<String> schema) { this.schema = schema; }

    /**
     * Retrieve the {@code table} property (displayed as '{@literal Table}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("table")
    public List<String> getTable() { return this.table; }

    /**
     * Set the {@code table} property (displayed as {@code Table}) of the object.
     * @param table the value to set
     */
    @JsonProperty("table")
    public void setTable(List<String> table) { this.table = table; }

}
