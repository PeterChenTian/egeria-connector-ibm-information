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
import java.util.Date;

/**
 * POJO for the {@code job_fail_event} asset type in IGC, displayed as '{@literal Job Fail Event}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=JobFailEvent.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("job_fail_event")
public class JobFailEvent extends Reference {

    @JsonProperty("job_run_activity")
    protected InformationAsset jobRunActivity;

    @JsonProperty("message")
    protected String message;

    @JsonProperty("row_count")
    protected Number rowCount;

    @JsonProperty("time")
    protected Date time;

    /**
     * Retrieve the {@code job_run_activity} property (displayed as '{@literal Job Run Activity}') of the object.
     * @return {@code InformationAsset}
     */
    @JsonProperty("job_run_activity")
    public InformationAsset getJobRunActivity() { return this.jobRunActivity; }

    /**
     * Set the {@code job_run_activity} property (displayed as {@code Job Run Activity}) of the object.
     * @param jobRunActivity the value to set
     */
    @JsonProperty("job_run_activity")
    public void setJobRunActivity(InformationAsset jobRunActivity) { this.jobRunActivity = jobRunActivity; }

    /**
     * Retrieve the {@code message} property (displayed as '{@literal Message}') of the object.
     * @return {@code String}
     */
    @JsonProperty("message")
    public String getMessage() { return this.message; }

    /**
     * Set the {@code message} property (displayed as {@code Message}) of the object.
     * @param message the value to set
     */
    @JsonProperty("message")
    public void setMessage(String message) { this.message = message; }

    /**
     * Retrieve the {@code row_count} property (displayed as '{@literal Row Count}') of the object.
     * @return {@code Number}
     */
    @JsonProperty("row_count")
    public Number getRowCount() { return this.rowCount; }

    /**
     * Set the {@code row_count} property (displayed as {@code Row Count}) of the object.
     * @param rowCount the value to set
     */
    @JsonProperty("row_count")
    public void setRowCount(Number rowCount) { this.rowCount = rowCount; }

    /**
     * Retrieve the {@code time} property (displayed as '{@literal Time}') of the object.
     * @return {@code Date}
     */
    @JsonProperty("time")
    public Date getTime() { return this.time; }

    /**
     * Set the {@code time} property (displayed as {@code Time}) of the object.
     * @param time the value to set
     */
    @JsonProperty("time")
    public void setTime(Date time) { this.time = time; }

}
