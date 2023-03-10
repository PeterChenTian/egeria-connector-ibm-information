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
 * POJO for the {@code credential} asset type in IGC, displayed as '{@literal Credential}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=Credential.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("credential")
public class Credential extends Reference {

    @JsonProperty("default_for_application_install")
    protected ApplicationInstall defaultForApplicationInstall;

    @JsonProperty("for_application_install")
    protected ApplicationInstall forApplicationInstall;

    @JsonProperty("of_user_credentials")
    protected Credentials ofUserCredentials;

    @JsonProperty("password")
    protected String password;

    @JsonProperty("used_by_user_credentials")
    protected Credentials usedByUserCredentials;

    @JsonProperty("username")
    protected String username;

    /**
     * Retrieve the {@code default_for_application_install} property (displayed as '{@literal Default For Application Install}') of the object.
     * @return {@code ApplicationInstall}
     */
    @JsonProperty("default_for_application_install")
    public ApplicationInstall getDefaultForApplicationInstall() { return this.defaultForApplicationInstall; }

    /**
     * Set the {@code default_for_application_install} property (displayed as {@code Default For Application Install}) of the object.
     * @param defaultForApplicationInstall the value to set
     */
    @JsonProperty("default_for_application_install")
    public void setDefaultForApplicationInstall(ApplicationInstall defaultForApplicationInstall) { this.defaultForApplicationInstall = defaultForApplicationInstall; }

    /**
     * Retrieve the {@code for_application_install} property (displayed as '{@literal For Application Install}') of the object.
     * @return {@code ApplicationInstall}
     */
    @JsonProperty("for_application_install")
    public ApplicationInstall getForApplicationInstall() { return this.forApplicationInstall; }

    /**
     * Set the {@code for_application_install} property (displayed as {@code For Application Install}) of the object.
     * @param forApplicationInstall the value to set
     */
    @JsonProperty("for_application_install")
    public void setForApplicationInstall(ApplicationInstall forApplicationInstall) { this.forApplicationInstall = forApplicationInstall; }

    /**
     * Retrieve the {@code of_user_credentials} property (displayed as '{@literal Of User Credentials}') of the object.
     * @return {@code Credentials}
     */
    @JsonProperty("of_user_credentials")
    public Credentials getOfUserCredentials() { return this.ofUserCredentials; }

    /**
     * Set the {@code of_user_credentials} property (displayed as {@code Of User Credentials}) of the object.
     * @param ofUserCredentials the value to set
     */
    @JsonProperty("of_user_credentials")
    public void setOfUserCredentials(Credentials ofUserCredentials) { this.ofUserCredentials = ofUserCredentials; }

    /**
     * Retrieve the {@code password} property (displayed as '{@literal Password}') of the object.
     * @return {@code String}
     */
    @JsonProperty("password")
    public String getPassword() { return this.password; }

    /**
     * Set the {@code password} property (displayed as {@code Password}) of the object.
     * @param password the value to set
     */
    @JsonProperty("password")
    public void setPassword(String password) { this.password = password; }

    /**
     * Retrieve the {@code used_by_user_credentials} property (displayed as '{@literal Used By User Credentials}') of the object.
     * @return {@code Credentials}
     */
    @JsonProperty("used_by_user_credentials")
    public Credentials getUsedByUserCredentials() { return this.usedByUserCredentials; }

    /**
     * Set the {@code used_by_user_credentials} property (displayed as {@code Used By User Credentials}) of the object.
     * @param usedByUserCredentials the value to set
     */
    @JsonProperty("used_by_user_credentials")
    public void setUsedByUserCredentials(Credentials usedByUserCredentials) { this.usedByUserCredentials = usedByUserCredentials; }

    /**
     * Retrieve the {@code username} property (displayed as '{@literal Username}') of the object.
     * @return {@code String}
     */
    @JsonProperty("username")
    public String getUsername() { return this.username; }

    /**
     * Set the {@code username} property (displayed as {@code Username}) of the object.
     * @param username the value to set
     */
    @JsonProperty("username")
    public void setUsername(String username) { this.username = username; }

}
