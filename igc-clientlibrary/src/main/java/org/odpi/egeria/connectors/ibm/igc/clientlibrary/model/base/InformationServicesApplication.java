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

/**
 * POJO for the {@code information_services_application} asset type in IGC, displayed as '{@literal Information Services Application}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=InformationServicesApplication.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("information_services_application")
public class InformationServicesApplication extends InformationAsset {

    @JsonProperty("description")
    protected String description;

    @JsonProperty("information_services_project")
    protected InformationServicesProject informationServicesProject;

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
     * Retrieve the {@code information_services_project} property (displayed as '{@literal Information Services Project}') of the object.
     * @return {@code InformationServicesProject}
     */
    @JsonProperty("information_services_project")
    public InformationServicesProject getInformationServicesProject() { return this.informationServicesProject; }

    /**
     * Set the {@code information_services_project} property (displayed as {@code Information Services Project}) of the object.
     * @param informationServicesProject the value to set
     */
    @JsonProperty("information_services_project")
    public void setInformationServicesProject(InformationServicesProject informationServicesProject) { this.informationServicesProject = informationServicesProject; }

}
