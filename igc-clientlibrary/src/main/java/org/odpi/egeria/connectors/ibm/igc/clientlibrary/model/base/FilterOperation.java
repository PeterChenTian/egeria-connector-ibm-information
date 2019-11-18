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

/**
 * POJO for the {@code filter_operation} asset type in IGC, displayed as '{@literal Filter Operation}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=FilterOperation.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("filter_operation")
public class FilterOperation extends Reference {

    @JsonProperty("filter")
    protected Filter filter;

    @JsonProperty("infoset")
    protected Infoset infoset;

    @JsonProperty("primary_input")
    protected Infoset primaryInput;

    /**
     * Retrieve the {@code filter} property (displayed as '{@literal Filter}') of the object.
     * @return {@code Filter}
     */
    @JsonProperty("filter")
    public Filter getFilter() { return this.filter; }

    /**
     * Set the {@code filter} property (displayed as {@code Filter}) of the object.
     * @param filter the value to set
     */
    @JsonProperty("filter")
    public void setFilter(Filter filter) { this.filter = filter; }

    /**
     * Retrieve the {@code infoset} property (displayed as '{@literal InfoSet}') of the object.
     * @return {@code Infoset}
     */
    @JsonProperty("infoset")
    public Infoset getInfoset() { return this.infoset; }

    /**
     * Set the {@code infoset} property (displayed as {@code InfoSet}) of the object.
     * @param infoset the value to set
     */
    @JsonProperty("infoset")
    public void setInfoset(Infoset infoset) { this.infoset = infoset; }

    /**
     * Retrieve the {@code primary_input} property (displayed as '{@literal Primary Input}') of the object.
     * @return {@code Infoset}
     */
    @JsonProperty("primary_input")
    public Infoset getPrimaryInput() { return this.primaryInput; }

    /**
     * Set the {@code primary_input} property (displayed as {@code Primary Input}) of the object.
     * @param primaryInput the value to set
     */
    @JsonProperty("primary_input")
    public void setPrimaryInput(Infoset primaryInput) { this.primaryInput = primaryInput; }

}
