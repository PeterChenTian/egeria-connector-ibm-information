/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.entities;

import org.odpi.egeria.connectors.ibm.igc.auditlog.IGCOMRSErrorCode;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestClient;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestConstants;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCVersionEnum;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.cache.ObjectCache;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.errors.IGCException;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.Identity;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.Reference;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearchCondition;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearchConditionSet;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.relationships.CategoryAnchorMapper;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.relationships.TermAnchorMapper;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;

/**
 * Defines the mapping to the OMRS "GlossaryCategory" entity.
 */
public class GlossaryMapper extends ReferenceableMapper {

    public static final String IGC_RID_PREFIX = "GL";

    private static class Singleton {
        private static final GlossaryMapper INSTANCE = new GlossaryMapper();
    }

    public static GlossaryMapper getInstance(IGCVersionEnum version) {
        return Singleton.INSTANCE;
    }

    protected GlossaryMapper() {

        // Start by calling the superclass's constructor to initialise the Mapper
        super(
                "category",
                "Category",
                "Glossary",
                IGC_RID_PREFIX
        );

        // The list of properties that should be mapped
        addSimplePropertyMapping("name", "displayName");
        addSimplePropertyMapping("short_description", "description");
        addSimplePropertyMapping("language", "language");
        addSimplePropertyMapping("long_description", "usage");

        // The classes to use for mapping any relationships
        addRelationshipMapper(CategoryAnchorMapper.getInstance(null));
        addRelationshipMapper(TermAnchorMapper.getInstance(null));

        // TODO: The classes to use for mapping any classifications
        //addClassificationMapper(TaxonomyMapper.getInstance(null));
        //addClassificationMapper(CanonicalVocabularyMapper.getInstance(null));

    }

    /**
     * Utility method to check if the provided IGC object should be treated as a Glossary (true) or not (false).
     *
     * @param igcRestClient connectivity to the IGC environment
     * @param cache         a cache of information that may already have been retrieved about the provided object
     * @param igcObject     the IGC object to check
     *
     * @return boolean
     *
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public static boolean isGlossary(IGCRestClient igcRestClient, ObjectCache cache, Reference igcObject) throws RepositoryErrorException {
        final String methodName = "isGlossary";
        String assetType = IGCRestConstants.getAssetTypeForSearch(igcObject.getType());
        if (assetType.equals("category")) {
            try {
                Identity catIdentity = igcObject.getIdentity(igcRestClient, cache);
                Identity parentIdentity = catIdentity.getParentIdentity();
                return parentIdentity == null && !catIdentity.getName().equals("Classifications");
            } catch (IGCException e) {
                raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
            }
        }
        return false;
    }

    /**
     * Utility method to check if the provided IGC object should be treated as a Glossary (true) or not (false).
     * @param identity the identity of the asset
     *
     * @return boolean
     *
     */
    public static boolean isGlossary(Identity identity) {
        String assetType = IGCRestConstants.getAssetTypeForSearch(identity.getAssetType());
        if ("category".equals(assetType)) {
            Identity parentIdentity = identity.getParentIdentity();
            return parentIdentity == null && !identity.getName().equals("Classifications");
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOmrsType(IGCRestClient igcRestClient, ObjectCache cache, Reference igcObject) throws RepositoryErrorException {
        return isGlossary(igcRestClient, cache, igcObject);
    }

    /**
     * Search for Glossaries by looking for a category with no parent category.
     *
     * @return IGCSearchConditionSet - the IGC search criteria to find Glossary entities
     */
    @Override
    public IGCSearchConditionSet getIGCSearchCriteria() {
        IGCSearchCondition rootLevel = new IGCSearchCondition("parent_category", "isNull", false);
        IGCSearchCondition notClassification = new IGCSearchCondition("name", "=", "Classifications", true);
        IGCSearchConditionSet conditions = new IGCSearchConditionSet(rootLevel);
        conditions.addCondition(notClassification);
        conditions.setMatchAnyCondition(false);
        return conditions;
    }

}
