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
import java.util.Date;

/**
 * POJO for the {@code data_rule_results} asset type in IGC, displayed as '{@literal Data Rule Results}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=DataRuleResults.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("data_rule_results")
public class DataRuleResults extends Reference {

    @JsonProperty("benchmark")
    protected String benchmark;

    @JsonProperty("end_time")
    protected Date endTime;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("native_id")
    protected String nativeId;

    @JsonProperty("number_of_records_met")
    protected Number numberOfRecordsMet;

    @JsonProperty("number_of_records_not_met")
    protected Number numberOfRecordsNotMet;

    @JsonProperty("number_of_records_tested")
    protected Number numberOfRecordsTested;

    @JsonProperty("rule_results")
    protected ItemList<RuleExecutionResult> ruleResults;

    @JsonProperty("start_time")
    protected Date startTime;

    /**
     * Retrieve the {@code benchmark} property (displayed as '{@literal Benchmark}') of the object.
     * @return {@code String}
     */
    @JsonProperty("benchmark")
    public String getBenchmark() { return this.benchmark; }

    /**
     * Set the {@code benchmark} property (displayed as {@code Benchmark}) of the object.
     * @param benchmark the value to set
     */
    @JsonProperty("benchmark")
    public void setBenchmark(String benchmark) { this.benchmark = benchmark; }

    /**
     * Retrieve the {@code end_time} property (displayed as '{@literal End Time}') of the object.
     * @return {@code Date}
     */
    @JsonProperty("end_time")
    public Date getEndTime() { return this.endTime; }

    /**
     * Set the {@code end_time} property (displayed as {@code End Time}) of the object.
     * @param endTime the value to set
     */
    @JsonProperty("end_time")
    public void setEndTime(Date endTime) { this.endTime = endTime; }

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
     * Retrieve the {@code number_of_records_met} property (displayed as '{@literal Number of Records Met}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("number_of_records_met")
    public Number getNumberOfRecordsMet() { return this.numberOfRecordsMet; }

    /**
     * Set the {@code number_of_records_met} property (displayed as {@code Number of Records Met}) of the object.
     * @param numberOfRecordsMet the value to set
     */
    @JsonProperty("number_of_records_met")
    public void setNumberOfRecordsMet(Number numberOfRecordsMet) { this.numberOfRecordsMet = numberOfRecordsMet; }

    /**
     * Retrieve the {@code number_of_records_not_met} property (displayed as '{@literal Number of Records Not Met}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("number_of_records_not_met")
    public Number getNumberOfRecordsNotMet() { return this.numberOfRecordsNotMet; }

    /**
     * Set the {@code number_of_records_not_met} property (displayed as {@code Number of Records Not Met}) of the object.
     * @param numberOfRecordsNotMet the value to set
     */
    @JsonProperty("number_of_records_not_met")
    public void setNumberOfRecordsNotMet(Number numberOfRecordsNotMet) { this.numberOfRecordsNotMet = numberOfRecordsNotMet; }

    /**
     * Retrieve the {@code number_of_records_tested} property (displayed as '{@literal Number of Records Tested}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("number_of_records_tested")
    public Number getNumberOfRecordsTested() { return this.numberOfRecordsTested; }

    /**
     * Set the {@code number_of_records_tested} property (displayed as {@code Number of Records Tested}) of the object.
     * @param numberOfRecordsTested the value to set
     */
    @JsonProperty("number_of_records_tested")
    public void setNumberOfRecordsTested(Number numberOfRecordsTested) { this.numberOfRecordsTested = numberOfRecordsTested; }

    /**
     * Retrieve the {@code rule_results} property (displayed as '{@literal Rule Results}') of the object.
     * @return {@code ItemList<RuleExecutionResult>}
     */
    @JsonProperty("rule_results")
    public ItemList<RuleExecutionResult> getRuleResults() { return this.ruleResults; }

    /**
     * Set the {@code rule_results} property (displayed as {@code Rule Results}) of the object.
     * @param ruleResults the value to set
     */
    @JsonProperty("rule_results")
    public void setRuleResults(ItemList<RuleExecutionResult> ruleResults) { this.ruleResults = ruleResults; }

    /**
     * Retrieve the {@code start_time} property (displayed as '{@literal Start Time}') of the object.
     * @return {@code Date}
     */
    @JsonProperty("start_time")
    public Date getStartTime() { return this.startTime; }

    /**
     * Set the {@code start_time} property (displayed as {@code Start Time}) of the object.
     * @param startTime the value to set
     */
    @JsonProperty("start_time")
    public void setStartTime(Date startTime) { this.startTime = startTime; }

}
