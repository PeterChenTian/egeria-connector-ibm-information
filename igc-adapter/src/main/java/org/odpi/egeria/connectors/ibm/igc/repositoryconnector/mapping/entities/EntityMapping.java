/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.entities;

import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestClient;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestConstants;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.cache.ObjectCache;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.errors.IGCException;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.Reference;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearchConditionSet;
import org.odpi.egeria.connectors.ibm.igc.auditlog.IGCOMRSErrorCode;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.IGCOMRSMetadataCollection;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.IGCOMRSRepositoryConnector;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.IGCRepositoryHelper;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.InstanceMapping;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.EntityMappingInstance;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.attributes.AttributeMapping;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.classifications.ClassificationMapping;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.relationships.RelationshipMapping;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.model.IGCEntityGuid;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.SequencingOrder;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.*;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.search.PropertyComparisonOperator;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.AttributeTypeDefCategory;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.TypeDefAttribute;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityNotKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.FunctionNotSupportedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Provides the base class for all entity mappings.
 */
public abstract class EntityMapping extends InstanceMapping {

    private static final Logger log = LoggerFactory.getLogger(EntityMapping.class);

    private String igcAssetType;
    private String igcAssetTypeDisplayName;
    private String omrsTypeDefName;
    private String igcRidPrefix;

    private ArrayList<String> otherIgcTypes;

    public static final String COMPLEX_MAPPING_SENTINEL = "__COMPLEX_PROPERTY__";
    public static final String LITERAL_MAPPING_SENTINEL = "__LITERAL_MAPPING__";
    public static final String SUPERTYPE_SENTINEL = "__SUPERTYPE_WITH_NO_DIRECT_MAPPING__";

    private Map<String, PropertyMapping> mappingByIgcProperty;
    private Map<String, PropertyMapping> mappingByOmrsProperty;

    private HashSet<String> complexIgcProperties;
    private HashSet<String> complexOmrsProperties;

    private ArrayList<RelationshipMapping> relationshipMappers;
    private ArrayList<ClassificationMapping> classificationMappers;

    private ArrayList<InstanceStatus> omrsSupportedStatuses;

    EntityMapping(String igcAssetType,
                  String igcAssetTypeDisplayName,
                  String omrsTypeDefName,
                  String igcRidPrefix) {
        super(true);
        init(igcAssetType, igcAssetTypeDisplayName, omrsTypeDefName, igcRidPrefix);
    }

    EntityMapping(String igcAssetType,
                  String igcAssetTypeDisplayName,
                  String omrsTypeDefName,
                  String igcRidPrefix,
                  boolean searchable) {
        super(searchable);
        init(igcAssetType, igcAssetTypeDisplayName, omrsTypeDefName, igcRidPrefix);
    }

    private void init(String igcAssetType,
                      String igcAssetTypeDisplayName,
                      String omrsTypeDefName,
                      String igcRidPrefix) {
        this.igcAssetType = igcAssetType;
        this.igcAssetTypeDisplayName = igcAssetTypeDisplayName;
        this.omrsTypeDefName = omrsTypeDefName;
        this.igcRidPrefix = igcRidPrefix;
        this.mappingByIgcProperty = new HashMap<>();
        this.mappingByOmrsProperty = new HashMap<>();
        this.complexIgcProperties = new HashSet<>();
        this.complexOmrsProperties = new HashSet<>();
        this.relationshipMappers = new ArrayList<>();
        this.classificationMappers = new ArrayList<>();
        this.omrsSupportedStatuses = new ArrayList<>();
        addSupportedStatus(InstanceStatus.ACTIVE);
        addSupportedStatus(InstanceStatus.DELETED);
        this.otherIgcTypes = new ArrayList<>();
    }

    /**
     * Subclass to contain individual mappings.
     */
    public static final class PropertyMapping {

        private String igcPropertyName;
        private String omrsPropertyName;

        public PropertyMapping(String igcPropertyName, String omrsPropertyName) {
            this.igcPropertyName = igcPropertyName;
            this.omrsPropertyName = omrsPropertyName;
        }

        public String getIgcPropertyName() { return this.igcPropertyName; }
        public String getOmrsPropertyName() { return this.omrsPropertyName; }

    }

    /**
     * Add the provided status as one supported by this entity mapping.
     *
     * @param status a status that is supported by the mapping
     */
    private void addSupportedStatus(InstanceStatus status) { this.omrsSupportedStatuses.add(status); }

    /**
     * Retrieve the list of statuses that are supported by the entity mapping.
     *
     * @return {@code List<InstanceStatus>}
     */
    public final List<InstanceStatus> getSupportedStatuses() { return this.omrsSupportedStatuses; }

    /**
     * Retrieve the primary IGC asset type used by this mapping.
     *
     * @return String
     */
    public final String getIgcAssetType() { return this.igcAssetType; }

    /**
     * Retrieve the display name of the primary IGC asset type used by this mapping. (The display name is also the name
     * used by the InfosphereEvents topic of the event mapper.)
     *
     * @return String
     */
    public final String getIgcAssetTypeDisplayName() { return this.igcAssetTypeDisplayName; }

    /**
     * Indicates whether the IGC Repository ID (RID) requires a prefix (true) or not (false). A prefix is typically
     * required when the entity represented by the RID does not actually exist as a distinct entity in IGC, but is
     * rather a subset of properties, relationships and classifications from another IGC asset type. (The prefix allows
     * us to effectively split such a singular IGC object into multiple OMRS entities.)
     *
     * @return boolean
     * @see #getIgcRidPrefix()
     */
    public final boolean igcRidNeedsPrefix() { return (this.igcRidPrefix != null); }

    /**
     * Retrieves the IGC Repository ID (RID) prefix required by this entity, if any (or null if none is needed).
     *
     * @return String
     * @see #igcRidNeedsPrefix()
     */
    public final String getIgcRidPrefix() { return this.igcRidPrefix; }

    /**
     * Retrieves the name of the OMRS TypeDef that this mapping translates IGC objects into.
     *
     * @return String
     */
    public final String getOmrsTypeDefName() { return this.omrsTypeDefName; }

    /**
     * Indicates whether this entity mapping matches the provided IGC asset type: that is, this mapping
     * can be used to translate to the provided IGC asset type.
     *
     * @param igcAssetType the IGC asset type to check the mapping against
     * @return boolean
     */
    public final boolean matchesAssetType(String igcAssetType) {
        String matchType = IGCRestConstants.getAssetTypeForSearch(igcAssetType);
        return (
                this.igcAssetType.equals(matchType)
                        || this.igcAssetType.equals(IGCRepositoryHelper.DEFAULT_IGC_TYPE)
        );
    }

    /**
     * Indicates whether the provided asset represents the OMRS type defined in the entity mapping (true)
     * or not (false). This is primarily useful for any singular object types in IGC that map to multiple types in
     * OMRS depending on certain characteristics, in which case this method should be overridden by the entity mapping
     * implementation to define those criteria. In the majority of cases this does not need to be overridden and
     * simply returns true directly.
     *
     * @param igcRestClient connectivity to the IGC environment
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param igcObject the IGC object to check matches the OMRS type or not
     * @return boolean
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public boolean isOmrsType(IGCRestClient igcRestClient, ObjectCache cache, Reference igcObject) throws RepositoryErrorException {
        return true;
    }

    /**
     * Add any other IGC asset type needed for this mapping.
     *
     * @param igcAssetTypeName name of additional IGC asset
     */
    final void addOtherIGCAssetType(String igcAssetTypeName) {
        this.otherIgcTypes.add(igcAssetTypeName);
    }

    /**
     * Retrieve listing of any additional IGC asset types needed by this mapping.
     *
     * @return {@code List<String>}
     */
    public final List<String> getOtherIGCAssetTypes() { return this.otherIgcTypes; }

    /**
     * Add a simple one-to-one property mapping between an IGC property and an OMRS property.
     *
     * @param igcPropertyName the IGC property name to be mapped
     * @param omrsPropertyName the OMRS property name to be mapped
     */
    public final void addSimplePropertyMapping(String igcPropertyName, String omrsPropertyName) {
        if (igcPropertyName != null && omrsPropertyName != null) {
            PropertyMapping pm = new PropertyMapping(igcPropertyName, omrsPropertyName);
            if (mappingByOmrsProperty.containsKey(omrsPropertyName)) {
                // If we are overriding an existing mapping, remove that mapping before applying the new one
                // (to release the previously-mapped values into eg. additionalProperties map)
                PropertyMapping existing = mappingByOmrsProperty.remove(omrsPropertyName);
                mappingByIgcProperty.remove(existing.getIgcPropertyName());
            }
            // Remove any existing literal property mapping (no-op if there is not one)
            removeLiteralPropertyMapping(omrsPropertyName);
            mappingByOmrsProperty.put(omrsPropertyName, pm);
            mappingByIgcProperty.put(igcPropertyName, pm);
        } else {
            log.warn("Attempted to add null property to mapping -- IGC = {}, OMRS = {}", igcPropertyName, omrsPropertyName);
        }
    }

    /**
     * Note the provided IGC property name as requiring more than a simple one-to-one mapping to an OMRS property.
     *
     * @param igcPropertyName the IGC property name
     */
    public final void addComplexIgcProperty(String igcPropertyName) {
        if (igcPropertyName != null) {
            complexIgcProperties.add(igcPropertyName);
        } else {
            log.warn("Attempted to add null property to mapping -- IGC.");
        }
    }

    /**
     * Note the provided OMRS property name as requiring more than a simple one-to-one mapping to an IGC property.
     *
     * @param omrsPropertyName the OMRS property name
     */
    final void addComplexOmrsProperty(String omrsPropertyName) {
        if (omrsPropertyName != null) {
            complexOmrsProperties.add(omrsPropertyName);
            // Remove any existing literal property mapping (no-op if there is not one)
            removeLiteralPropertyMapping(omrsPropertyName);
        } else {
            log.warn("Attempted to add null property to mapping -- OMRS.");
        }
    }

    /**
     * Returns only the subset of mapped IGC properties that are simple one-to-one mappings to OMRS properties.
     *
     * @return {@code Set<String>}
     */
    public Set<String> getSimpleMappedIgcProperties() {
        return mappingByIgcProperty.keySet();
    }

    /**
     * Returns only the subset of mapped IGC properties that are complex mappings to OMRS properties.
     *
     * @return {@code Set<String>}
     */
    public final Set<String> getComplexMappedIgcProperties() {
        return complexIgcProperties;
    }

    /**
     * Returns the set of all IGC properties that are mapped to OMRS properties.
     *
     * @return {@code Set<String>}
     */
    public final Set<String> getAllMappedIgcProperties() {
        HashSet<String> igcProperties = new HashSet<>(getSimpleMappedIgcProperties());
        if (getComplexMappedIgcProperties() != null) {
            igcProperties.addAll(getComplexMappedIgcProperties());
        }
        return igcProperties;
    }

    /**
     * Returns only the subset of mapped OMRS properties that are simple one-to-one mappings to IGC properties.
     *
     * @return {@code Set<String>}
     */
    private Set<String> getSimpleMappedOmrsProperties() {
        return mappingByOmrsProperty.keySet();
    }

    /**
     * Returns only the subset of mapped OMRS properties that are complex mappings to IGC properties.
     *
     * @return {@code Set<String>}
     */
    protected Set<String> getComplexMappedOmrsProperties() {
        return complexOmrsProperties;
    }

    /**
     * Returns only the subset of mapped OMRS properties that can be written (created or updated).
     *
     * @return {@code Set<String>}
     */
    public final Set<String> getWriteableMappedOmrsProperties() {
        HashSet<String> omrsProperties = new HashSet<>(getSimpleMappedOmrsProperties());
        omrsProperties.addAll(getComplexMappedOmrsProperties());
        return omrsProperties;
    }

    /**
     * Returns the set of OMRS property names that are mapped: either to IGC properties, or as fixed (literal) values.
     *
     * @return {@code Set<String>}
     */
    @Override
    public Set<String> getMappedOmrsPropertyNames() {
        HashSet<String> omrsProperties = new HashSet<>(getSimpleMappedOmrsProperties());
        if (getComplexMappedOmrsProperties() != null) {
            omrsProperties.addAll(getComplexMappedOmrsProperties());
        }
        if (getLiteralPropertyMappings() != null) {
            omrsProperties.addAll(getLiteralPropertyMappings());
        }
        return omrsProperties;
    }

    /**
     * Retrieves the IGC property name mapped to the provided OMRS property name.
     *
     * @param omrsPropertyName the OMRS property name for which to get the mapped IGC property name
     * @return String
     */
    public final String getIgcPropertyName(String omrsPropertyName) {
        String igcPropertyName = null;
        if (isOmrsPropertySimpleMapped(omrsPropertyName)) {
            igcPropertyName = mappingByOmrsProperty.get(omrsPropertyName).getIgcPropertyName();
        } else if (isOmrsPropertyComplexMapped(omrsPropertyName)) {
            igcPropertyName = COMPLEX_MAPPING_SENTINEL;
        } else if (isOmrsPropertyLiteralMapped(omrsPropertyName)) {
            igcPropertyName = LITERAL_MAPPING_SENTINEL;
        }
        return igcPropertyName;
    }

    /**
     * Retrieves the OMRS property name mapped to the provided IGC property name.
     *
     * @param igcPropertyName the IGC property name for which to get the mapped OMRS property name.
     * @return String
     */
    public final String getOmrsPropertyName(String igcPropertyName) {
        String omrsPropertyName = null;
        if (isIgcPropertySimpleMapped(igcPropertyName)) {
            omrsPropertyName = mappingByIgcProperty.get(igcPropertyName).getOmrsPropertyName();
        } else if (isIgcPropertyComplexMapped(igcPropertyName)) {
            omrsPropertyName = COMPLEX_MAPPING_SENTINEL;
        }
        return omrsPropertyName;
    }

    /**
     * Determines whether the provided IGC property name is simple (one-to-one) mapped (true) or not (false).
     *
     * @param igcPropertyName the IGC property name to check for a simple mapping
     * @return boolean
     */
    private boolean isIgcPropertySimpleMapped(String igcPropertyName) {
        return mappingByIgcProperty.containsKey(igcPropertyName);
    }

    /**
     * Determines whether the provided IGC property name is complex mapped (true) or not (false).
     *
     * @param igcPropertyName the IGC property name to check for a complex mapping
     * @return boolean
     */
    private boolean isIgcPropertyComplexMapped(String igcPropertyName) {
        return complexIgcProperties.contains(igcPropertyName);
    }

    /**
     * Determines whether the provided OMRS property name is simple (one-to-one) mapped (true) or not (false).
     *
     * @param omrsPropertyName the OMRS property name to check for a simple mapping
     * @return boolean
     */
    private boolean isOmrsPropertySimpleMapped(String omrsPropertyName) {
        return mappingByOmrsProperty.containsKey(omrsPropertyName);
    }

    /**
     * Determines whether the provided OMRS property name is complex mapped (true) or not (false).
     *
     * @param omrsPropertyName the OMRS property name to check for a complex mapping
     * @return boolean
     */
    private boolean isOmrsPropertyComplexMapped(String omrsPropertyName) {
        return complexOmrsProperties.contains(omrsPropertyName);
    }

    /**
     * Add the provided relationship mapping as one that describes relationships for this entity.
     *
     * @param relationshipMapping the relationship mapping to add
     */
    public final void addRelationshipMapper(RelationshipMapping relationshipMapping) {
        relationshipMappers.add(relationshipMapping);
    }

    /**
     * Retrieve the relationship mappings for this entity.
     *
     * @return {@code List<RelationshipMapping>}
     */
    public final List<RelationshipMapping> getRelationshipMappers() { return this.relationshipMappers; }

    /**
     * Add the provided classification mapping as one that describes classifications for this entity.
     *
     * @param classificationMapping the classification mapping to add
     */
    public final void addClassificationMapper(ClassificationMapping classificationMapping) {
        classificationMappers.add(classificationMapping);
    }

    /**
     * Retrieve the classification mappings for this entity.
     *
     * @return {@code List<ClassificationMapping>}
     */
    public final List<ClassificationMapping> getClassificationMappers() { return this.classificationMappers; }

    /**
     * Retrieve the base IGC 'asset' expected for the mapper from one of its alternative assets. By default, and in the
     * vast majority of cases, there are no alternatives so will simply return the 'asset' as-is. Override this method
     * in any mappers where alternative assets are defined.
     *
     * Note as well that the 'asset' returned will only have its ID (RID) and Type populated, it is not a "real" IGC
     * asset.
     *
     * @param igcAssetType the IGC asset type of the alternative asset to translate into a base asset
     * @param igcRid the IGC Repository ID (RID) of the alternative asset to translate into a base asset
     * @param igcomrsRepositoryConnector connectivity to IGC repository
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @return Reference - a stripped-down base asset containing only the ID and Type
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public Reference getBaseIgcAssetFromAlternative(String igcAssetType,
                                                    String igcRid,
                                                    IGCOMRSRepositoryConnector igcomrsRepositoryConnector,
                                                    ObjectCache cache) throws RepositoryErrorException {
        Reference simple = new Reference();
        simple.setId(igcRid);
        simple.setType(igcAssetType);
        return simple;
    }

    /**
     * This method needs to be overridden to define complex property mapping logic (if any).
     *
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param entityMap the instantiation of a mapping to carry out
     * @param instanceProperties the instance properties to which to add the complex-mapped properties
     * @return InstanceProperties
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    protected InstanceProperties complexPropertyMappings(ObjectCache cache,
                                                         EntityMappingInstance entityMap,
                                                         InstanceProperties instanceProperties) throws RepositoryErrorException {
        // Nothing to do -- no complex properties by default
        // (only modification details, but because we want those on EntitySummary as well they're handled elsewhere)
        return instanceProperties;
    }

    /**
     * This method needs to be overridden to define how to search for an entity using a property value that has been
     * mapped in a complex way.
     *
     * @param repositoryHelper helper for the OMRS repository
     * @param repositoryName name of the repository
     * @param igcRestClient connectivity to an IGC environment
     * @param igcSearchConditionSet the set of search criteria to which to add
     * @param igcPropertyName the IGC property name (or COMPLEX_MAPPING_SENTINEL) to search
     * @param omrsPropertyName the OMRS property name (or COMPLEX_MAPPING_SENTINEL) to search
     * @param operator the comparison operator to use
     * @param value the value for which to search
     * @throws FunctionNotSupportedException when a regular expression is used for the search that is not supported
     * @throws RepositoryErrorException on any other error
     */
    public void addComplexPropertySearchCriteria(OMRSRepositoryHelper repositoryHelper,
                                                 String repositoryName,
                                                 IGCRestClient igcRestClient,
                                                 IGCSearchConditionSet igcSearchConditionSet,
                                                 String igcPropertyName,
                                                 String omrsPropertyName,
                                                 PropertyComparisonOperator operator,
                                                 InstancePropertyValue value) throws FunctionNotSupportedException, RepositoryErrorException {
        // Nothing to do -- no complex properties by default
    }

    /**
     * This method needs to be overridden to define how to search for an entity using a string-based regex match
     * against all of its potential String properties.
     *
     * @param repositoryHelper helper for the OMRS repository
     * @param repositoryName name of the repository
     * @param igcRestClient connectivity to an IGC environment
     * @param igcSearchConditionSet the set of search criteria to which to add
     * @param searchCriteria the regular expression to attempt to match against any string properties
     * @throws FunctionNotSupportedException when a regular expression is used for the search that is not supported
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public void addComplexStringSearchCriteria(OMRSRepositoryHelper repositoryHelper,
                                               String repositoryName,
                                               IGCRestClient igcRestClient,
                                               IGCSearchConditionSet igcSearchConditionSet,
                                               String searchCriteria) throws FunctionNotSupportedException, RepositoryErrorException {
        // Nothing to do -- no complex properties by default
    }

    /**
     * Implement this method to define how IGC entities can be searched.
     *
     * In most cases, no special conditions are required and therefore this simply returns an empty set of conditions
     * by default.  However, in cases where an IGC asset type is overloaded (mapped to multiple OMRS types), this
     * method must be overridden to define how to limit the OMRS results to one type or another.
     *
     * @return IGCSearchConditionSet - the IGC search criteria to find entities based on this classification
     */
    public IGCSearchConditionSet getIGCSearchCriteria() {
        return new IGCSearchConditionSet();
    }

    /**
     * Simple utility function to avoid implementing shared EntitySummary and EntityDetail setup twice.
     *
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param entityMap the instantiation of a mapping to carry out
     * @param omrsObj the summary object to setup
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    private static void setupEntityObj(ObjectCache cache,
                                       EntityMappingInstance entityMap,
                                       EntitySummary omrsObj) throws RepositoryErrorException {

        final String methodName = "setupEntityObj";
        Reference igcEntity = entityMap.getIgcEntity();
        EntityMapping mapping = entityMap.getMapping();
        IGCOMRSRepositoryConnector igcomrsRepositoryConnector = entityMap.getRepositoryConnector();
        IGCRestClient igcRestClient = igcomrsRepositoryConnector.getIGCRestClient();
        String userId = entityMap.getUserId();

        try {
            if (igcRestClient.hasModificationDetails(igcEntity.getType())) {
                InstanceMapping.setupInstanceModDetails(omrsObj,
                        igcEntity.getCreatedBy(),
                        igcEntity.getCreatedOn(),
                        igcEntity.getModifiedBy(),
                        igcEntity.getModifiedOn());
            }
        } catch (IGCException e) {
            raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
        }

        List<Classification> omrsClassifications = entityMap.getOmrsClassifications();

        // Avoid doing this multiple times: if one has retrieved classifications it'll
        // be the same classifications for the other
        List<ClassificationMapping> classificationMappings = mapping.getClassificationMappers();
        if (!classificationMappings.isEmpty() && omrsClassifications.isEmpty()) {
            for (ClassificationMapping classificationMapping : classificationMappings) {
                classificationMapping.addMappedOMRSClassifications(
                        igcomrsRepositoryConnector,
                        omrsClassifications,
                        cache,
                        igcEntity,
                        userId
                );
            }
        }

        omrsObj.setClassifications(omrsClassifications);

    }

    /**
     * Retrieve a listing of all of the properties we want to retrieve to have a complete EntitySummary for this
     * mapping.
     *
     * @param igcRestClient REST connectivity to the IGC environment
     * @param igcAssetType the asset type for which to retrieve properties
     * @return {@code List<String>}
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public final List<String> getAllPropertiesForEntitySummary(IGCRestClient igcRestClient,
                                                               String igcAssetType) throws RepositoryErrorException {
        final String methodName = "getAllPropertiesForEntitySummary";
        Set<String> allProperties = new TreeSet<>();
        for (ClassificationMapping classificationMapping : getClassificationMappers()) {
            Set<String> classificationProperties = classificationMapping.getMappedIgcPropertyNames();
            if (classificationProperties != null) {
                allProperties.addAll(classificationProperties);
            }
        }
        allProperties.addAll(getAllMappedIgcProperties());
        try {
            // Restrict the set of properties to those that are known by this particular version of IGC
            List<String> allKnownProperties = igcRestClient.getAllPropertiesForType(igcAssetType);
            allProperties.retainAll(allKnownProperties);
        } catch (IGCException e) {
            raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
        }
        return new ArrayList<>(allProperties);
    }

    /**
     * Map the IGC entity to an OMRS EntitySummary object.
     *
     * @param entityMap the instantiation of a mapping to carry out
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @return EntitySummary
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public static final EntitySummary getEntitySummary(EntityMappingInstance entityMap, ObjectCache cache) throws RepositoryErrorException {

        EntityMapping mapping = entityMap.getMapping();
        IGCRestClient igcRestClient = entityMap.getRepositoryConnector().getIGCRestClient();

        if (!entityMap.isIgcEntityAlreadyRetrieved()) {
            entityMap.setPropertiesToRetrieveForIgcEntity(mapping.getAllPropertiesForEntitySummary(igcRestClient, entityMap.getIgcEntityType()));
        }
        entityMap.initializeEntitySummary();

        EntitySummary preliminary = entityMap.getOmrsSummary(cache);
        if (preliminary != null) {
            setupEntityObj(cache, entityMap, preliminary);
        }
        return entityMap.getOmrsSummary(cache);

    }

    /**
     * Retrieve a listing of all of the properties we want to retrieve to have a complete EntityDetail for this
     * mapping.
     *
     * @param igcRestClient REST connectivity to the IGC environment
     * @param igcAssetType the asset type for which to retrieve properties
     * @return {@code List<String>}
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public final List<String> getAllPropertiesForEntityDetail(IGCRestClient igcRestClient,
                                                              String igcAssetType) throws RepositoryErrorException {
        final String methodName = "getAllPropertiesForEntityDetail";
        Set<String> allProperties = new TreeSet<>(getAllMappedIgcProperties());
        for (ClassificationMapping classificationMapping : getClassificationMappers()) {
            Set<String> classificationProperties = classificationMapping.getMappedIgcPropertyNames();
            if (classificationProperties != null) {
                allProperties.addAll(classificationProperties);
            }
        }
        try {
            List<String> nonRelationshipProperties = igcRestClient.getNonRelationshipPropertiesForType(igcAssetType);
            if (nonRelationshipProperties != null) {
                allProperties.addAll(nonRelationshipProperties);
            }
            // Restrict the set of properties to those that are known by this particular version of IGC
            List<String> allKnownProperties = igcRestClient.getAllPropertiesForType(igcAssetType);
            allProperties.retainAll(allKnownProperties);
        } catch (IGCException e) {
            raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
        }
        return new ArrayList<>(allProperties);
    }

    /**
     * Map the IGC entity to an OMRS EntityDetail object.
     *
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param entityMap the instantiation of a mapping to carry out
     * @return EntityDetail
     * @throws RepositoryErrorException if any issue interacting with IGC
     * @throws EntityNotKnownException if the entity cannot be found
     */
    public static EntityDetail getEntityDetail(ObjectCache cache, EntityMappingInstance entityMap) throws RepositoryErrorException, EntityNotKnownException {

        final String methodName = "getEntityDetail";
        EntityMapping mapping = entityMap.getMapping();
        IGCRestClient igcRestClient = entityMap.getRepositoryConnector().getIGCRestClient();

        if (!entityMap.isIgcEntityAlreadyRetrieved()) {
            // Retrieve only this set of properties for the object (no more, no less)
            entityMap.setPropertiesToRetrieveForIgcEntity(
                    mapping.getAllPropertiesForEntityDetail(
                            igcRestClient,
                            entityMap.getIgcEntityType())
            );
        }

        // Handle any super-generic mappings first
        entityMap.initializeEntityDetail();


        if (entityMap.getIgcEntity() == null) {
            // Igc entity was not found, raise exception providing as much details as possible
            raiseEntityNotKnownException(IGCOMRSErrorCode.ENTITY_NOT_KNOWN,
                    methodName,
                    null,
                    "",
                    entityMap.getIgcEntityRid() != null ? entityMap.getIgcEntityRid() : "",
                    entityMap.getRepositoryConnector().getRepositoryName());
        }

        EntityDetail preliminary = entityMap.getOmrsDetail(cache);

        if (preliminary != null) {
            // Then handle any generic mappings and classifications
            setupEntityObj(cache, entityMap, preliminary);

            // Use reflection to apply POJO-specific mappings
            InstanceProperties instanceProperties = getMappedInstanceProperties(cache, entityMap);
            entityMap.updateOmrsDetailWithProperties(instanceProperties);
        }

        return entityMap.getOmrsDetail(cache);

    }

    /**
     * Retrieves the InstanceProperties based on the mappings provided.
     *
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param entityMap the instantiation of a mapping to carry out
     * @return InstanceProperties
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    private static InstanceProperties getMappedInstanceProperties(ObjectCache cache, EntityMappingInstance entityMap) throws RepositoryErrorException {

        final String methodName = "getMappedInstanceProperties";

        IGCOMRSRepositoryConnector igcomrsRepositoryConnector = entityMap.getRepositoryConnector();
        IGCOMRSMetadataCollection igcomrsMetadataCollection = entityMap.getMetadataCollection();
        OMRSRepositoryHelper omrsRepositoryHelper = igcomrsRepositoryConnector.getRepositoryHelper();
        IGCRestClient igcRestClient = igcomrsRepositoryConnector.getIGCRestClient();
        Reference igcEntity = entityMap.getIgcEntity();
        String repositoryName = igcomrsRepositoryConnector.getRepositoryName();
        EntityMapping mapping = entityMap.getMapping();
        String omrsTypeDefName = mapping.getOmrsTypeDefName();

        Map<String, TypeDefAttribute> omrsAttributeMap = igcomrsMetadataCollection.getTypeDefAttributesForType(omrsTypeDefName);

        InstanceProperties instanceProperties = new InstanceProperties();

        // Then we'll iterate through the provided mappings to set an OMRS instance property for each one
        for (String igcPropertyName : mapping.getSimpleMappedIgcProperties()) {
            String omrsAttribute = mapping.getOmrsPropertyName(igcPropertyName);
            if (omrsAttributeMap.containsKey(omrsAttribute)) {
                TypeDefAttribute typeDefAttribute = omrsAttributeMap.get(omrsAttribute);
                try {
                    instanceProperties = AttributeMapping.addPrimitivePropertyToInstance(
                            omrsRepositoryHelper,
                            repositoryName,
                            instanceProperties,
                            typeDefAttribute,
                            igcRestClient.getPropertyByName(igcEntity, igcPropertyName),
                            methodName
                    );
                } catch (IGCException e) {
                    raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
                }
            } else {
                log.warn("No OMRS attribute {} defined for asset type {} -- skipping mapping.", omrsAttribute, omrsTypeDefName);
            }
        }

        // Then any fixed (literal) property mappings
        for (String omrsPropertyName : mapping.getLiteralPropertyMappings()) {
            if (omrsAttributeMap.containsKey(omrsPropertyName)) {
                Object value = mapping.getOmrsPropertyLiteralValue(omrsPropertyName);
                if (value != null) {
                    TypeDefAttribute typeDefAttribute = omrsAttributeMap.get(omrsPropertyName);
                    AttributeTypeDefCategory attributeTypeDefCategory = typeDefAttribute.getAttributeType().getCategory();
                    if (attributeTypeDefCategory == AttributeTypeDefCategory.PRIMITIVE) {
                        instanceProperties = AttributeMapping.addPrimitivePropertyToInstance(
                                omrsRepositoryHelper,
                                repositoryName,
                                instanceProperties,
                                typeDefAttribute,
                                value,
                                methodName
                        );
                    } else {
                        instanceProperties.setProperty(omrsPropertyName, (InstancePropertyValue)value);
                    }
                }
            }
        }

        // Finally we'll apply any complex property mappings
        mapping.complexPropertyMappings(cache, entityMap, instanceProperties);

        return instanceProperties;

    }

    /**
     * Retrieves the mapped relationships for the entity.
     *
     * @param igcGuid the IGC GUID of the entity for which to retrieve the mapped relationships
     * @param entityMap the instantiation of a mapping to carry out
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param relationshipTypeGUID String GUID of the the type of relationship required (null for all).
     * @param fromRelationshipElement the starting element number of the relationships to return.
     *                                This is used when retrieving elements
     *                                beyond the first page of results. Zero means start from the first element.
     * @param sequencingOrder Enum defining how the results should be ordered.
     * @param sequencingProperty String name of the property that is to be used to sequence the results.
     *                           Null means do not sequence on a property name (see SequencingOrder).
     * @param pageSize the maximum number of result classifications that can be returned on this request.  Zero means
     *                 unrestricted return results size.
     * @return {@code List<Relationship>}
     * @throws EntityNotKnownException if the entity for which we are looking for relationships is not known to IGC
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    public static List<Relationship> getMappedRelationships(IGCEntityGuid igcGuid,
                                                            EntityMappingInstance entityMap,
                                                            ObjectCache cache,
                                                            String relationshipTypeGUID,
                                                            int fromRelationshipElement,
                                                            SequencingOrder sequencingOrder,
                                                            String sequencingProperty,
                                                            int pageSize) throws EntityNotKnownException, RepositoryErrorException {

        final String methodName = "getMappedRelationships";

        // Initialize our mapping instance with the basic details we'll require for the relationships
        entityMap.initializeIGCReference();
        Reference igcEntity = entityMap.getIgcEntity();

        if (igcEntity == null) {
            throw new EntityNotKnownException(IGCOMRSErrorCode.ENTITY_NOT_KNOWN.getMessageDefinition(igcGuid.toString(), "null", entityMap.getRepositoryConnector().getRepositoryName()),
                    EntityMapping.class.getName(),
                    methodName);
        } else {
            EntityMapping entityMapping = entityMap.getMapping();
            IGCOMRSRepositoryConnector igcomrsRepositoryConnector = entityMap.getRepositoryConnector();
            String userId = entityMap.getUserId();
            List<Relationship> omrsRelationships = entityMap.getOmrsRelationships();

            List<RelationshipMapping> relationshipMappers = entityMapping.getRelationshipMappers();

            // If the sequencing requested is by property, just remove sequencing as all properties are literally-
            // mapped or empty on IGC relationships
            // TODO: one exception to this is where there is a relationship-level object, which needs to be handled
            //  (ie. data class assignments, where even literal-mapped properties like status can vary)
            SequencingOrder soForSearching = sequencingOrder;
            if (sequencingOrder != null && (sequencingOrder.equals(SequencingOrder.PROPERTY_DESCENDING) || sequencingOrder.equals(SequencingOrder.PROPERTY_ASCENDING))) {
                soForSearching = null;
            }

            RelationshipMapping.getMappedRelationships(
                    igcomrsRepositoryConnector,
                    omrsRelationships,
                    relationshipMappers,
                    cache,
                    relationshipTypeGUID,
                    igcEntity,
                    fromRelationshipElement,
                    soForSearching,
                    pageSize,
                    userId
            );

            // First sort the results (if any sorting was requested)
            Comparator<Relationship> comparator = null;
            if (sequencingOrder != null) {
                switch (sequencingOrder) {
                    case GUID:
                        comparator = Comparator.comparing(Relationship::getGUID);
                        break;
                    case LAST_UPDATE_RECENT:
                        comparator = Comparator.comparing(Relationship::getUpdateTime).reversed();
                        break;
                    case LAST_UPDATE_OLDEST:
                        comparator = Comparator.comparing(Relationship::getUpdateTime);
                        break;
                    case CREATION_DATE_RECENT:
                        comparator = Comparator.comparing(Relationship::getCreateTime).reversed();
                        break;
                    case CREATION_DATE_OLDEST:
                        comparator = Comparator.comparing(Relationship::getCreateTime);
                        break;
                    case PROPERTY_ASCENDING:
                        if (sequencingProperty != null) {
                            comparator = (a, b) -> {
                                InstanceProperties p1 = a.getProperties();
                                InstanceProperties p2 = b.getProperties();
                                InstancePropertyValue v1 = null;
                                InstancePropertyValue v2 = null;
                                if (p1 != null) {
                                    v1 = p1.getPropertyValue(sequencingProperty);
                                }
                                if (p2 != null) {
                                    v2 = p2.getPropertyValue(sequencingProperty);
                                }
                                return AttributeMapping.compareInstanceProperty(v1, v2);
                            };
                        }
                        break;
                    case PROPERTY_DESCENDING:
                        if (sequencingProperty != null) {
                            comparator = (b, a) -> {
                                InstanceProperties p1 = a.getProperties();
                                InstanceProperties p2 = b.getProperties();
                                InstancePropertyValue v1 = null;
                                InstancePropertyValue v2 = null;
                                if (p1 != null) {
                                    v1 = p1.getPropertyValue(sequencingProperty);
                                }
                                if (p2 != null) {
                                    v2 = p2.getPropertyValue(sequencingProperty);
                                }
                                return AttributeMapping.compareInstanceProperty(v1, v2);
                            };
                        }
                        break;
                    default:
                        log.debug("No sorting requested, skipping.");
                        break;
                }
            }
            if (comparator != null) {
                omrsRelationships.sort(comparator);
            }

            // Then trim the results to the total size requested
            List<Relationship> limited = new ArrayList<>();
            if (pageSize > 0) {
                if(fromRelationshipElement >= omrsRelationships.size()){
                    return limited;
                }
                limited = omrsRelationships.subList(fromRelationshipElement, Math.min(fromRelationshipElement + pageSize, omrsRelationships.size()));
            } else {
                limited = omrsRelationships.subList(fromRelationshipElement, omrsRelationships.size());
            }

            return limited;

        }

    }

}
