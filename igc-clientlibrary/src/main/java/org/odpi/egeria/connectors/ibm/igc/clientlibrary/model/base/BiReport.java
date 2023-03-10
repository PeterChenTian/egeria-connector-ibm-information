/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
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
 * POJO for the {@code bi_report} asset type in IGC, displayed as '{@literal BI Report}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=BiReport.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BiReportNocontext.class, name = "bi_report_nocontext"),
        @JsonSubTypes.Type(value = BiReportNofolder.class, name = "bi_report_nofolder"),
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("bi_report")
public class BiReport extends InformationAsset {

    @JsonProperty("alias_(business_name)")
    protected String aliasBusinessName;

    @JsonProperty("author")
    protected String author;

    @JsonProperty("bi_cube")
    protected BiCube biCube;

    @JsonProperty("bi_folder")
    protected BiFolder biFolder;

    @JsonProperty("bi_folder_or_bi_model_or_cube")
    protected ItemList<MainObject> biFolderOrBiModelOrCube;

    @JsonProperty("bi_model")
    protected BiModel biModel;

    @JsonProperty("bi_report_creation_date")
    protected Date biReportCreationDate;

    @JsonProperty("bi_report_modification_date")
    protected Date biReportModificationDate;

    @JsonProperty("bi_report_queries")
    protected ItemList<BiReportQuery> biReportQueries;

    @JsonProperty("bi_report_run_date")
    protected Date biReportRunDate;

    @JsonProperty("expression")
    protected List<String> expression;

    @JsonProperty("format")
    protected String format;

    @JsonProperty("imported_from")
    protected String importedFrom;

    @JsonProperty("include_for_business_lineage")
    protected Boolean includeForBusinessLineage;

    @JsonProperty("language")
    protected String language;

    @JsonProperty("namespace")
    protected String namespace;

    @JsonProperty("number_of_runs")
    protected Number numberOfRuns;

    @JsonProperty("number_of_versions")
    protected Number numberOfVersions;

    @JsonProperty("referenced_by_bi_reports")
    protected ItemList<BiReport> referencedByBiReports;

    @JsonProperty("references_bi_reports")
    protected ItemList<BiReport> referencesBiReports;

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
     * Retrieve the {@code author} property (displayed as '{@literal Author}') of the object.
     * @return {@code String}
     */
    @JsonProperty("author")
    public String getAuthor() { return this.author; }

    /**
     * Set the {@code author} property (displayed as {@code Author}) of the object.
     * @param author the value to set
     */
    @JsonProperty("author")
    public void setAuthor(String author) { this.author = author; }

    /**
     * Retrieve the {@code bi_cube} property (displayed as '{@literal BI Cube}') of the object.
     * @return {@code BiCube}
     */
    @JsonProperty("bi_cube")
    public BiCube getBiCube() { return this.biCube; }

    /**
     * Set the {@code bi_cube} property (displayed as {@code BI Cube}) of the object.
     * @param biCube the value to set
     */
    @JsonProperty("bi_cube")
    public void setBiCube(BiCube biCube) { this.biCube = biCube; }

    /**
     * Retrieve the {@code bi_folder} property (displayed as '{@literal BI Folder}') of the object.
     * @return {@code BiFolder}
     */
    @JsonProperty("bi_folder")
    public BiFolder getBiFolder() { return this.biFolder; }

    /**
     * Set the {@code bi_folder} property (displayed as {@code BI Folder}) of the object.
     * @param biFolder the value to set
     */
    @JsonProperty("bi_folder")
    public void setBiFolder(BiFolder biFolder) { this.biFolder = biFolder; }

    /**
     * Retrieve the {@code bi_folder_or_bi_model_or_cube} property (displayed as '{@literal BI Folder or BI Model or Cube}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("bi_folder_or_bi_model_or_cube")
    public ItemList<MainObject> getBiFolderOrBiModelOrCube() { return this.biFolderOrBiModelOrCube; }

    /**
     * Set the {@code bi_folder_or_bi_model_or_cube} property (displayed as {@code BI Folder or BI Model or Cube}) of the object.
     * @param biFolderOrBiModelOrCube the value to set
     */
    @JsonProperty("bi_folder_or_bi_model_or_cube")
    public void setBiFolderOrBiModelOrCube(ItemList<MainObject> biFolderOrBiModelOrCube) { this.biFolderOrBiModelOrCube = biFolderOrBiModelOrCube; }

    /**
     * Retrieve the {@code bi_model} property (displayed as '{@literal BI Model}') of the object.
     * @return {@code BiModel}
     */
    @JsonProperty("bi_model")
    public BiModel getBiModel() { return this.biModel; }

    /**
     * Set the {@code bi_model} property (displayed as {@code BI Model}) of the object.
     * @param biModel the value to set
     */
    @JsonProperty("bi_model")
    public void setBiModel(BiModel biModel) { this.biModel = biModel; }

    /**
     * Retrieve the {@code bi_report_creation_date} property (displayed as '{@literal BI Report Creation Date}') of the object.
     * @return {@code Date}
     */
    @JsonProperty("bi_report_creation_date")
    public Date getBiReportCreationDate() { return this.biReportCreationDate; }

    /**
     * Set the {@code bi_report_creation_date} property (displayed as {@code BI Report Creation Date}) of the object.
     * @param biReportCreationDate the value to set
     */
    @JsonProperty("bi_report_creation_date")
    public void setBiReportCreationDate(Date biReportCreationDate) { this.biReportCreationDate = biReportCreationDate; }

    /**
     * Retrieve the {@code bi_report_modification_date} property (displayed as '{@literal BI Report Modification Date}') of the object.
     * @return {@code Date}
     */
    @JsonProperty("bi_report_modification_date")
    public Date getBiReportModificationDate() { return this.biReportModificationDate; }

    /**
     * Set the {@code bi_report_modification_date} property (displayed as {@code BI Report Modification Date}) of the object.
     * @param biReportModificationDate the value to set
     */
    @JsonProperty("bi_report_modification_date")
    public void setBiReportModificationDate(Date biReportModificationDate) { this.biReportModificationDate = biReportModificationDate; }

    /**
     * Retrieve the {@code bi_report_queries} property (displayed as '{@literal BI Report Queries}') of the object.
     * @return {@code ItemList<BiReportQuery>}
     */
    @JsonProperty("bi_report_queries")
    public ItemList<BiReportQuery> getBiReportQueries() { return this.biReportQueries; }

    /**
     * Set the {@code bi_report_queries} property (displayed as {@code BI Report Queries}) of the object.
     * @param biReportQueries the value to set
     */
    @JsonProperty("bi_report_queries")
    public void setBiReportQueries(ItemList<BiReportQuery> biReportQueries) { this.biReportQueries = biReportQueries; }

    /**
     * Retrieve the {@code bi_report_run_date} property (displayed as '{@literal BI Report Run Date}') of the object.
     * @return {@code Date}
     */
    @JsonProperty("bi_report_run_date")
    public Date getBiReportRunDate() { return this.biReportRunDate; }

    /**
     * Set the {@code bi_report_run_date} property (displayed as {@code BI Report Run Date}) of the object.
     * @param biReportRunDate the value to set
     */
    @JsonProperty("bi_report_run_date")
    public void setBiReportRunDate(Date biReportRunDate) { this.biReportRunDate = biReportRunDate; }

    /**
     * Retrieve the {@code expression} property (displayed as '{@literal Expression}') of the object.
     * @return {@code List<String>}
     */
    @JsonProperty("expression")
    public List<String> getExpression() { return this.expression; }

    /**
     * Set the {@code expression} property (displayed as {@code Expression}) of the object.
     * @param expression the value to set
     */
    @JsonProperty("expression")
    public void setExpression(List<String> expression) { this.expression = expression; }

    /**
     * Retrieve the {@code format} property (displayed as '{@literal Format}') of the object.
     * @return {@code String}
     */
    @JsonProperty("format")
    public String getFormat() { return this.format; }

    /**
     * Set the {@code format} property (displayed as {@code Format}) of the object.
     * @param format the value to set
     */
    @JsonProperty("format")
    public void setFormat(String format) { this.format = format; }

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
     * Retrieve the {@code language} property (displayed as '{@literal Language}') of the object.
     * @return {@code String}
     */
    @JsonProperty("language")
    public String getLanguage() { return this.language; }

    /**
     * Set the {@code language} property (displayed as {@code Language}) of the object.
     * @param language the value to set
     */
    @JsonProperty("language")
    public void setLanguage(String language) { this.language = language; }

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
     * Retrieve the {@code number_of_runs} property (displayed as '{@literal Number of Runs}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("number_of_runs")
    public Number getNumberOfRuns() { return this.numberOfRuns; }

    /**
     * Set the {@code number_of_runs} property (displayed as {@code Number of Runs}) of the object.
     * @param numberOfRuns the value to set
     */
    @JsonProperty("number_of_runs")
    public void setNumberOfRuns(Number numberOfRuns) { this.numberOfRuns = numberOfRuns; }

    /**
     * Retrieve the {@code number_of_versions} property (displayed as '{@literal Number of Versions}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("number_of_versions")
    public Number getNumberOfVersions() { return this.numberOfVersions; }

    /**
     * Set the {@code number_of_versions} property (displayed as {@code Number of Versions}) of the object.
     * @param numberOfVersions the value to set
     */
    @JsonProperty("number_of_versions")
    public void setNumberOfVersions(Number numberOfVersions) { this.numberOfVersions = numberOfVersions; }

    /**
     * Retrieve the {@code referenced_by_bi_reports} property (displayed as '{@literal Referenced by BI Reports}') of the object.
     * @return {@code ItemList<BiReport>}
     */
    @JsonProperty("referenced_by_bi_reports")
    public ItemList<BiReport> getReferencedByBiReports() { return this.referencedByBiReports; }

    /**
     * Set the {@code referenced_by_bi_reports} property (displayed as {@code Referenced by BI Reports}) of the object.
     * @param referencedByBiReports the value to set
     */
    @JsonProperty("referenced_by_bi_reports")
    public void setReferencedByBiReports(ItemList<BiReport> referencedByBiReports) { this.referencedByBiReports = referencedByBiReports; }

    /**
     * Retrieve the {@code references_bi_reports} property (displayed as '{@literal References BI Reports}') of the object.
     * @return {@code ItemList<BiReport>}
     */
    @JsonProperty("references_bi_reports")
    public ItemList<BiReport> getReferencesBiReports() { return this.referencesBiReports; }

    /**
     * Set the {@code references_bi_reports} property (displayed as {@code References BI Reports}) of the object.
     * @param referencesBiReports the value to set
     */
    @JsonProperty("references_bi_reports")
    public void setReferencesBiReports(ItemList<BiReport> referencesBiReports) { this.referencesBiReports = referencesBiReports; }

}
