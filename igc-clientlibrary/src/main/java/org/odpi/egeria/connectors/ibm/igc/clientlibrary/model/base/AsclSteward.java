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
 * POJO for the {@code ascl_steward} asset type in IGC, displayed as '{@literal Steward}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=AsclSteward.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("ascl_steward")
public class AsclSteward extends Reference {

    @JsonProperty("email_address")
    protected String emailAddress;

    @JsonProperty("managed_assets")
    protected ItemList<InformationAsset> managedAssets;

    @JsonProperty("managed_assets_basic")
    protected ItemList<MainObject> managedAssetsBasic;

    @JsonProperty("organization")
    protected String organization;

    @JsonProperty("steward_group")
    protected StewardGroup stewardGroup;

    @JsonProperty("steward_user")
    protected StewardUser stewardUser;

    /**
     * Retrieve the {@code email_address} property (displayed as '{@literal Email Address}') of the object.
     * @return {@code String}
     */
    @JsonProperty("email_address")
    public String getEmailAddress() { return this.emailAddress; }

    /**
     * Set the {@code email_address} property (displayed as {@code Email Address}) of the object.
     * @param emailAddress the value to set
     */
    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    /**
     * Retrieve the {@code managed_assets} property (displayed as '{@literal Managed Assets}') of the object.
     * @return {@code ItemList<InformationAsset>}
     */
    @JsonProperty("managed_assets")
    public ItemList<InformationAsset> getManagedAssets() { return this.managedAssets; }

    /**
     * Set the {@code managed_assets} property (displayed as {@code Managed Assets}) of the object.
     * @param managedAssets the value to set
     */
    @JsonProperty("managed_assets")
    public void setManagedAssets(ItemList<InformationAsset> managedAssets) { this.managedAssets = managedAssets; }

    /**
     * Retrieve the {@code managed_assets_basic} property (displayed as '{@literal Managed Assets}') of the object.
     * @return {@code ItemList<MainObject>}
     */
    @JsonProperty("managed_assets_basic")
    public ItemList<MainObject> getManagedAssetsBasic() { return this.managedAssetsBasic; }

    /**
     * Set the {@code managed_assets_basic} property (displayed as {@code Managed Assets}) of the object.
     * @param managedAssetsBasic the value to set
     */
    @JsonProperty("managed_assets_basic")
    public void setManagedAssetsBasic(ItemList<MainObject> managedAssetsBasic) { this.managedAssetsBasic = managedAssetsBasic; }

    /**
     * Retrieve the {@code organization} property (displayed as '{@literal Organization}') of the object.
     * @return {@code String}
     */
    @JsonProperty("organization")
    public String getOrganization() { return this.organization; }

    /**
     * Set the {@code organization} property (displayed as {@code Organization}) of the object.
     * @param organization the value to set
     */
    @JsonProperty("organization")
    public void setOrganization(String organization) { this.organization = organization; }

    /**
     * Retrieve the {@code steward_group} property (displayed as '{@literal Steward Group}') of the object.
     * @return {@code StewardGroup}
     */
    @JsonProperty("steward_group")
    public StewardGroup getStewardGroup() { return this.stewardGroup; }

    /**
     * Set the {@code steward_group} property (displayed as {@code Steward Group}) of the object.
     * @param stewardGroup the value to set
     */
    @JsonProperty("steward_group")
    public void setStewardGroup(StewardGroup stewardGroup) { this.stewardGroup = stewardGroup; }

    /**
     * Retrieve the {@code steward_user} property (displayed as '{@literal Steward User}') of the object.
     * @return {@code StewardUser}
     */
    @JsonProperty("steward_user")
    public StewardUser getStewardUser() { return this.stewardUser; }

    /**
     * Set the {@code steward_user} property (displayed as {@code Steward User}) of the object.
     * @param stewardUser the value to set
     */
    @JsonProperty("steward_user")
    public void setStewardUser(StewardUser stewardUser) { this.stewardUser = stewardUser; }

}
