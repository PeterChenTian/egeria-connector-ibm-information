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
 * POJO for the {@code stage} asset type in IGC, displayed as '{@literal Stage}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=Stage.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("stage")
public class Stage extends InformationAsset {

    @JsonProperty("after_sql")
    protected String afterSql;

    @JsonProperty("all_sql_statements")
    protected String allSqlStatements;

    @JsonProperty("before_sql")
    protected String beforeSql;

    @JsonProperty("constraints")
    protected ItemList<JobConstraint> constraints;

    @JsonProperty("data_rule_definition")
    protected ItemList<StageDataRuleDefinition> dataRuleDefinition;

    @JsonProperty("data_source_or_server")
    protected String dataSourceOrServer;

    @JsonProperty("delete_sql")
    protected String deleteSql;

    @JsonProperty("file")
    protected String file;

    @JsonProperty("host")
    protected String host;

    @JsonProperty("input_links")
    protected ItemList<Link> inputLinks;

    @JsonProperty("insert_sql")
    protected String insertSql;

    @JsonProperty("job")
    protected ItemList<Dsjob> job;

    @JsonProperty("job_or_container")
    protected ItemList<MainObject> jobOrContainer;

    @JsonProperty("manually_bound_to")
    protected ItemList<MainObject> manuallyBoundTo;

    @JsonProperty("match_specifications")
    protected ItemList<MatchSpecification> matchSpecifications;

    @JsonProperty("next_stages")
    protected ItemList<Stage> nextStages;

    @JsonProperty("output_links")
    protected ItemList<Link> outputLinks;

    @JsonProperty("previous_stages")
    protected ItemList<Stage> previousStages;

    @JsonProperty("reads_from_(design)")
    protected ItemList<InformationAsset> readsFromDesign;

    @JsonProperty("reads_from_(operational)")
    protected ItemList<InformationAsset> readsFromOperational;

    @JsonProperty("reads_from_(static)")
    protected ItemList<InformationAsset> readsFromStatic;

    @JsonProperty("reads_from_(user_defined)")
    protected ItemList<InformationAsset> readsFromUserDefined;

    @JsonProperty("references_container")
    protected SharedContainer referencesContainer;

    @JsonProperty("references_data_connection_mapping")
    protected ItemList<DataConnectionMapping> referencesDataConnectionMapping;

    @JsonProperty("references_table_definitions")
    protected ItemList<TableDefinition> referencesTableDefinitions;

    @JsonProperty("runs_sequences_jobs")
    protected Dsjob runsSequencesJobs;

    @JsonProperty("schema")
    protected String schema;

    @JsonProperty("shared_or_local_container")
    protected SharedContainer sharedOrLocalContainer;

    @JsonProperty("sql_statement")
    protected String sqlStatement;

    @JsonProperty("stage_variable")
    protected ItemList<StageVariable> stageVariable;

    @JsonProperty("standardization_rule_sets")
    protected ItemList<StandardizationRuleSet> standardizationRuleSets;

    @JsonProperty("table")
    protected String table;

    @JsonProperty("type")
    protected DsstageType type;

    @JsonProperty("type_definition")
    protected String typeDefinition;

    @JsonProperty("update_sql")
    protected String updateSql;

    @JsonProperty("writes_to_(design)")
    protected ItemList<InformationAsset> writesToDesign;

    @JsonProperty("writes_to_(operational)")
    protected ItemList<InformationAsset> writesToOperational;

    @JsonProperty("writes_to_(static)")
    protected ItemList<InformationAsset> writesToStatic;

    @JsonProperty("writes_to_(user_defined)")
    protected ItemList<InformationAsset> writesToUserDefined;

    /**
     * Retrieve the {@code after_sql} property (displayed as '{@literal After SQL}') of the object.
     * @return {@code String}
     */
    @JsonProperty("after_sql")
    public String getAfterSql() { return this.afterSql; }

    /**
     * Set the {@code after_sql} property (displayed as {@code After SQL}) of the object.
     * @param afterSql the value to set
     */
    @JsonProperty("after_sql")
    public void setAfterSql(String afterSql) { this.afterSql = afterSql; }

    /**
     * Retrieve the {@code all_sql_statements} property (displayed as '{@literal All SQL Statements}') of the object.
     * @return {@code String}
     */
    @JsonProperty("all_sql_statements")
    public String getAllSqlStatements() { return this.allSqlStatements; }

    /**
     * Set the {@code all_sql_statements} property (displayed as {@code All SQL Statements}) of the object.
     * @param allSqlStatements the value to set
     */
    @JsonProperty("all_sql_statements")
    public void setAllSqlStatements(String allSqlStatements) { this.allSqlStatements = allSqlStatements; }

    /**
     * Retrieve the {@code before_sql} property (displayed as '{@literal Before SQL}') of the object.
     * @return {@code String}
     */
    @JsonProperty("before_sql")
    public String getBeforeSql() { return this.beforeSql; }

    /**
     * Set the {@code before_sql} property (displayed as {@code Before SQL}) of the object.
     * @param beforeSql the value to set
     */
    @JsonProperty("before_sql")
    public void setBeforeSql(String beforeSql) { this.beforeSql = beforeSql; }

    /**
     * Retrieve the {@code constraints} property (displayed as '{@literal Constraints}') of the object.
     * @return {@code ItemList<JobConstraint>}
     */
    @JsonProperty("constraints")
    public ItemList<JobConstraint> getConstraints() { return this.constraints; }

    /**
     * Set the {@code constraints} property (displayed as {@code Constraints}) of the object.
     * @param constraints the value to set
     */
    @JsonProperty("constraints")
    public void setConstraints(ItemList<JobConstraint> constraints) { this.constraints = constraints; }

    /**
     * Retrieve the {@code data_rule_definition} property (displayed as '{@literal Data Rule Definition}') of the object.
     * @return {@code ItemList<StageDataRuleDefinition>}
     */
    @JsonProperty("data_rule_definition")
    public ItemList<StageDataRuleDefinition> getDataRuleDefinition() { return this.dataRuleDefinition; }

    /**
     * Set the {@code data_rule_definition} property (displayed as {@code Data Rule Definition}) of the object.
     * @param dataRuleDefinition the value to set
     */
    @JsonProperty("data_rule_definition")
    public void setDataRuleDefinition(ItemList<StageDataRuleDefinition> dataRuleDefinition) { this.dataRuleDefinition = dataRuleDefinition; }

    /**
     * Retrieve the {@code data_source_or_server} property (displayed as '{@literal Data Source or Server}') of the object.
     * @return {@code String}
     */
    @JsonProperty("data_source_or_server")
    public String getDataSourceOrServer() { return this.dataSourceOrServer; }

    /**
     * Set the {@code data_source_or_server} property (displayed as {@code Data Source or Server}) of the object.
     * @param dataSourceOrServer the value to set
     */
    @JsonProperty("data_source_or_server")
    public void setDataSourceOrServer(String dataSourceOrServer) { this.dataSourceOrServer = dataSourceOrServer; }

    /**
     * Retrieve the {@code delete_sql} property (displayed as '{@literal Delete SQL}') of the object.
     * @return {@code String}
     */
    @JsonProperty("delete_sql")
    public String getDeleteSql() { return this.deleteSql; }

    /**
     * Set the {@code delete_sql} property (displayed as {@code Delete SQL}) of the object.
     * @param deleteSql the value to set
     */
    @JsonProperty("delete_sql")
    public void setDeleteSql(String deleteSql) { this.deleteSql = deleteSql; }

    /**
     * Retrieve the {@code file} property (displayed as '{@literal File}') of the object.
     * @return {@code String}
     */
    @JsonProperty("file")
    public String getFile() { return this.file; }

    /**
     * Set the {@code file} property (displayed as {@code File}) of the object.
     * @param file the value to set
     */
    @JsonProperty("file")
    public void setFile(String file) { this.file = file; }

    /**
     * Retrieve the {@code host} property (displayed as '{@literal Host}') of the object.
     * @return {@code String}
     */
    @JsonProperty("host")
    public String getHost() { return this.host; }

    /**
     * Set the {@code host} property (displayed as {@code Host}) of the object.
     * @param host the value to set
     */
    @JsonProperty("host")
    public void setHost(String host) { this.host = host; }

    /**
     * Retrieve the {@code input_links} property (displayed as '{@literal Input Links}') of the object.
     * @return {@code ItemList<Link>}
     */
    @JsonProperty("input_links")
    public ItemList<Link> getInputLinks() { return this.inputLinks; }

    /**
     * Set the {@code input_links} property (displayed as {@code Input Links}) of the object.
     * @param inputLinks the value to set
     */
    @JsonProperty("input_links")
    public void setInputLinks(ItemList<Link> inputLinks) { this.inputLinks = inputLinks; }

    /**
     * Retrieve the {@code insert_sql} property (displayed as '{@literal Insert SQL}') of the object.
     * @return {@code String}
     */
    @JsonProperty("insert_sql")
    public String getInsertSql() { return this.insertSql; }

    /**
     * Set the {@code insert_sql} property (displayed as {@code Insert SQL}) of the object.
     * @param insertSql the value to set
     */
    @JsonProperty("insert_sql")
    public void setInsertSql(String insertSql) { this.insertSql = insertSql; }

    /**
     * Retrieve the {@code job} property (displayed as '{@literal Job}') of the object.
     * @return {@code ItemList<Dsjob>}
     */
    @JsonProperty("job")
    public ItemList<Dsjob> getJob() { return this.job; }

    /**
     * Set the {@code job} property (displayed as {@code Job}) of the object.
     * @param job the value to set
     */
    @JsonProperty("job")
    public void setJob(ItemList<Dsjob> job) { this.job = job; }

    /**
     * Retrieve the {@code job_or_container} property (displayed as '{@literal Job or Container}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("job_or_container")
    public ItemList<MainObject> getJobOrContainer() { return this.jobOrContainer; }

    /**
     * Set the {@code job_or_container} property (displayed as {@code Job or Container}) of the object.
     * @param jobOrContainer the value to set
     */
    @JsonProperty("job_or_container")
    public void setJobOrContainer(ItemList<MainObject> jobOrContainer) { this.jobOrContainer = jobOrContainer; }

    /**
     * Retrieve the {@code manually_bound_to} property (displayed as '{@literal Manually Bound To}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("manually_bound_to")
    public ItemList<MainObject> getManuallyBoundTo() { return this.manuallyBoundTo; }

    /**
     * Set the {@code manually_bound_to} property (displayed as {@code Manually Bound To}) of the object.
     * @param manuallyBoundTo the value to set
     */
    @JsonProperty("manually_bound_to")
    public void setManuallyBoundTo(ItemList<MainObject> manuallyBoundTo) { this.manuallyBoundTo = manuallyBoundTo; }

    /**
     * Retrieve the {@code match_specifications} property (displayed as '{@literal Match Specifications}') of the object.
     * @return {@code ItemList<MatchSpecification>}
     */
    @JsonProperty("match_specifications")
    public ItemList<MatchSpecification> getMatchSpecifications() { return this.matchSpecifications; }

    /**
     * Set the {@code match_specifications} property (displayed as {@code Match Specifications}) of the object.
     * @param matchSpecifications the value to set
     */
    @JsonProperty("match_specifications")
    public void setMatchSpecifications(ItemList<MatchSpecification> matchSpecifications) { this.matchSpecifications = matchSpecifications; }

    /**
     * Retrieve the {@code next_stages} property (displayed as '{@literal Next Stages}') of the object.
     * @return {@code ItemList<Stage>}
     */
    @JsonProperty("next_stages")
    public ItemList<Stage> getNextStages() { return this.nextStages; }

    /**
     * Set the {@code next_stages} property (displayed as {@code Next Stages}) of the object.
     * @param nextStages the value to set
     */
    @JsonProperty("next_stages")
    public void setNextStages(ItemList<Stage> nextStages) { this.nextStages = nextStages; }

    /**
     * Retrieve the {@code output_links} property (displayed as '{@literal Output Links}') of the object.
     * @return {@code ItemList<Link>}
     */
    @JsonProperty("output_links")
    public ItemList<Link> getOutputLinks() { return this.outputLinks; }

    /**
     * Set the {@code output_links} property (displayed as {@code Output Links}) of the object.
     * @param outputLinks the value to set
     */
    @JsonProperty("output_links")
    public void setOutputLinks(ItemList<Link> outputLinks) { this.outputLinks = outputLinks; }

    /**
     * Retrieve the {@code previous_stages} property (displayed as '{@literal Previous Stages}') of the object.
     * @return {@code ItemList<Stage>}
     */
    @JsonProperty("previous_stages")
    public ItemList<Stage> getPreviousStages() { return this.previousStages; }

    /**
     * Set the {@code previous_stages} property (displayed as {@code Previous Stages}) of the object.
     * @param previousStages the value to set
     */
    @JsonProperty("previous_stages")
    public void setPreviousStages(ItemList<Stage> previousStages) { this.previousStages = previousStages; }

    /**
     * Retrieve the {@code reads_from_(design)} property (displayed as '{@literal Reads from (Design)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("reads_from_(design)")
    public ItemList<InformationAsset> getReadsFromDesign() { return this.readsFromDesign; }

    /**
     * Set the {@code reads_from_(design)} property (displayed as {@code Reads from (Design)}) of the object.
     * @param readsFromDesign the value to set
     */
    @JsonProperty("reads_from_(design)")
    public void setReadsFromDesign(ItemList<InformationAsset> readsFromDesign) { this.readsFromDesign = readsFromDesign; }

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
     * Retrieve the {@code reads_from_(static)} property (displayed as '{@literal Reads from (Static)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("reads_from_(static)")
    public ItemList<InformationAsset> getReadsFromStatic() { return this.readsFromStatic; }

    /**
     * Set the {@code reads_from_(static)} property (displayed as {@code Reads from (Static)}) of the object.
     * @param readsFromStatic the value to set
     */
    @JsonProperty("reads_from_(static)")
    public void setReadsFromStatic(ItemList<InformationAsset> readsFromStatic) { this.readsFromStatic = readsFromStatic; }

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

    /**
     * Retrieve the {@code references_container} property (displayed as '{@literal References Container}') of the object.
     * @return {@code SharedContainer}
     */
    @JsonProperty("references_container")
    public SharedContainer getReferencesContainer() { return this.referencesContainer; }

    /**
     * Set the {@code references_container} property (displayed as {@code References Container}) of the object.
     * @param referencesContainer the value to set
     */
    @JsonProperty("references_container")
    public void setReferencesContainer(SharedContainer referencesContainer) { this.referencesContainer = referencesContainer; }

    /**
     * Retrieve the {@code references_data_connection_mapping} property (displayed as '{@literal References Data Connection Mapping}') of the object.
     * @return {@code ItemList<DataConnectionMapping>}
     */
    @JsonProperty("references_data_connection_mapping")
    public ItemList<DataConnectionMapping> getReferencesDataConnectionMapping() { return this.referencesDataConnectionMapping; }

    /**
     * Set the {@code references_data_connection_mapping} property (displayed as {@code References Data Connection Mapping}) of the object.
     * @param referencesDataConnectionMapping the value to set
     */
    @JsonProperty("references_data_connection_mapping")
    public void setReferencesDataConnectionMapping(ItemList<DataConnectionMapping> referencesDataConnectionMapping) { this.referencesDataConnectionMapping = referencesDataConnectionMapping; }

    /**
     * Retrieve the {@code references_table_definitions} property (displayed as '{@literal References Table Definitions}') of the object.
     * @return {@code ItemList<TableDefinition>}
     */
    @JsonProperty("references_table_definitions")
    public ItemList<TableDefinition> getReferencesTableDefinitions() { return this.referencesTableDefinitions; }

    /**
     * Set the {@code references_table_definitions} property (displayed as {@code References Table Definitions}) of the object.
     * @param referencesTableDefinitions the value to set
     */
    @JsonProperty("references_table_definitions")
    public void setReferencesTableDefinitions(ItemList<TableDefinition> referencesTableDefinitions) { this.referencesTableDefinitions = referencesTableDefinitions; }

    /**
     * Retrieve the {@code runs_sequences_jobs} property (displayed as '{@literal Runs Sequences Jobs}') of the object.
     * @return {@code Dsjob}
     */
    @JsonProperty("runs_sequences_jobs")
    public Dsjob getRunsSequencesJobs() { return this.runsSequencesJobs; }

    /**
     * Set the {@code runs_sequences_jobs} property (displayed as {@code Runs Sequences Jobs}) of the object.
     * @param runsSequencesJobs the value to set
     */
    @JsonProperty("runs_sequences_jobs")
    public void setRunsSequencesJobs(Dsjob runsSequencesJobs) { this.runsSequencesJobs = runsSequencesJobs; }

    /**
     * Retrieve the {@code schema} property (displayed as '{@literal Schema}') of the object.
     * @return {@code String}
     */
    @JsonProperty("schema")
    public String getSchema() { return this.schema; }

    /**
     * Set the {@code schema} property (displayed as {@code Schema}) of the object.
     * @param schema the value to set
     */
    @JsonProperty("schema")
    public void setSchema(String schema) { this.schema = schema; }

    /**
     * Retrieve the {@code shared_or_local_container} property (displayed as '{@literal Shared or Local Container}') of the object.
     * @return {@code SharedContainer}
     */
    @JsonProperty("shared_or_local_container")
    public SharedContainer getSharedOrLocalContainer() { return this.sharedOrLocalContainer; }

    /**
     * Set the {@code shared_or_local_container} property (displayed as {@code Shared or Local Container}) of the object.
     * @param sharedOrLocalContainer the value to set
     */
    @JsonProperty("shared_or_local_container")
    public void setSharedOrLocalContainer(SharedContainer sharedOrLocalContainer) { this.sharedOrLocalContainer = sharedOrLocalContainer; }

    /**
     * Retrieve the {@code sql_statement} property (displayed as '{@literal SQL Statement}') of the object.
     * @return {@code String}
     */
    @JsonProperty("sql_statement")
    public String getSqlStatement() { return this.sqlStatement; }

    /**
     * Set the {@code sql_statement} property (displayed as {@code SQL Statement}) of the object.
     * @param sqlStatement the value to set
     */
    @JsonProperty("sql_statement")
    public void setSqlStatement(String sqlStatement) { this.sqlStatement = sqlStatement; }

    /**
     * Retrieve the {@code stage_variable} property (displayed as '{@literal Stage Variables}') of the object.
     * @return {@code ItemList<StageVariable>}
     */
    @JsonProperty("stage_variable")
    public ItemList<StageVariable> getStageVariable() { return this.stageVariable; }

    /**
     * Set the {@code stage_variable} property (displayed as {@code Stage Variables}) of the object.
     * @param stageVariable the value to set
     */
    @JsonProperty("stage_variable")
    public void setStageVariable(ItemList<StageVariable> stageVariable) { this.stageVariable = stageVariable; }

    /**
     * Retrieve the {@code standardization_rule_sets} property (displayed as '{@literal Standardization Rule Sets}') of the object.
     * @return {@code ItemList<StandardizationRuleSet>}
     */
    @JsonProperty("standardization_rule_sets")
    public ItemList<StandardizationRuleSet> getStandardizationRuleSets() { return this.standardizationRuleSets; }

    /**
     * Set the {@code standardization_rule_sets} property (displayed as {@code Standardization Rule Sets}) of the object.
     * @param standardizationRuleSets the value to set
     */
    @JsonProperty("standardization_rule_sets")
    public void setStandardizationRuleSets(ItemList<StandardizationRuleSet> standardizationRuleSets) { this.standardizationRuleSets = standardizationRuleSets; }

    /**
     * Retrieve the {@code table} property (displayed as '{@literal Table}') of the object.
     * @return {@code String}
     */
    @JsonProperty("table")
    public String getTable() { return this.table; }

    /**
     * Set the {@code table} property (displayed as {@code Table}) of the object.
     * @param table the value to set
     */
    @JsonProperty("table")
    public void setTable(String table) { this.table = table; }

    /**
     * Retrieve the {@code type} property (displayed as '{@literal Type}') of the object.
     * @return {@code DsstageType}
     */
    @JsonProperty("type")
    public DsstageType getTheType() { return this.type; }

    /**
     * Set the {@code type} property (displayed as {@code Type}) of the object.
     * @param type the value to set
     */
    @JsonProperty("type")
    public void setTheType(DsstageType type) { this.type = type; }

    /**
     * Retrieve the {@code type_definition} property (displayed as '{@literal Type Definition}') of the object.
     * @return {@code String}
     */
    @JsonProperty("type_definition")
    public String getTypeDefinition() { return this.typeDefinition; }

    /**
     * Set the {@code type_definition} property (displayed as {@code Type Definition}) of the object.
     * @param typeDefinition the value to set
     */
    @JsonProperty("type_definition")
    public void setTypeDefinition(String typeDefinition) { this.typeDefinition = typeDefinition; }

    /**
     * Retrieve the {@code update_sql} property (displayed as '{@literal Update SQL}') of the object.
     * @return {@code String}
     */
    @JsonProperty("update_sql")
    public String getUpdateSql() { return this.updateSql; }

    /**
     * Set the {@code update_sql} property (displayed as {@code Update SQL}) of the object.
     * @param updateSql the value to set
     */
    @JsonProperty("update_sql")
    public void setUpdateSql(String updateSql) { this.updateSql = updateSql; }

    /**
     * Retrieve the {@code writes_to_(design)} property (displayed as '{@literal Writes to (Design)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("writes_to_(design)")
    public ItemList<InformationAsset> getWritesToDesign() { return this.writesToDesign; }

    /**
     * Set the {@code writes_to_(design)} property (displayed as {@code Writes to (Design)}) of the object.
     * @param writesToDesign the value to set
     */
    @JsonProperty("writes_to_(design)")
    public void setWritesToDesign(ItemList<InformationAsset> writesToDesign) { this.writesToDesign = writesToDesign; }

    /**
     * Retrieve the {@code writes_to_(operational)} property (displayed as '{@literal Writes to (Operational)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("writes_to_(operational)")
    public ItemList<InformationAsset> getWritesToOperational() { return this.writesToOperational; }

    /**
     * Set the {@code writes_to_(operational)} property (displayed as {@code Writes to (Operational)}) of the object.
     * @param writesToOperational the value to set
     */
    @JsonProperty("writes_to_(operational)")
    public void setWritesToOperational(ItemList<InformationAsset> writesToOperational) { this.writesToOperational = writesToOperational; }

    /**
     * Retrieve the {@code writes_to_(static)} property (displayed as '{@literal Writes to (Static)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("writes_to_(static)")
    public ItemList<InformationAsset> getWritesToStatic() { return this.writesToStatic; }

    /**
     * Set the {@code writes_to_(static)} property (displayed as {@code Writes to (Static)}) of the object.
     * @param writesToStatic the value to set
     */
    @JsonProperty("writes_to_(static)")
    public void setWritesToStatic(ItemList<InformationAsset> writesToStatic) { this.writesToStatic = writesToStatic; }

    /**
     * Retrieve the {@code writes_to_(user_defined)} property (displayed as '{@literal Writes to (User-Defined)}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("writes_to_(user_defined)")
    public ItemList<InformationAsset> getWritesToUserDefined() { return this.writesToUserDefined; }

    /**
     * Set the {@code writes_to_(user_defined)} property (displayed as {@code Writes to (User-Defined)}) of the object.
     * @param writesToUserDefined the value to set
     */
    @JsonProperty("writes_to_(user_defined)")
    public void setWritesToUserDefined(ItemList<InformationAsset> writesToUserDefined) { this.writesToUserDefined = writesToUserDefined; }

}
