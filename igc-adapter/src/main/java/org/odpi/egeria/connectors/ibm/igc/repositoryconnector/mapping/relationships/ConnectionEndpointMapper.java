/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.relationships;

import org.odpi.egeria.connectors.ibm.igc.auditlog.IGCOMRSErrorCode;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestClient;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestConstants;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCVersionEnum;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.cache.ObjectCache;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.errors.IGCException;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base.Connector;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base.DataConnection;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.ItemList;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.Reference;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearch;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearchCondition;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearchConditionSet;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.search.IGCSearchSorting;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.IGCOMRSRepositoryConnector;
import org.odpi.egeria.connectors.ibm.igc.repositoryconnector.IGCRepositoryHelper;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.SequencingOrder;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Relationship;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.RelationshipDef;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton to map the OMRS "ConnectionEndpoint" relationship between IGC "host" and "data_connection" assets
 * (via "connector" assets where needed).
 */
public class ConnectionEndpointMapper extends RelationshipMapping {

    private static final Logger log = LoggerFactory.getLogger(ConnectionEndpointMapper.class);

    private static class Singleton {
        private static final ConnectionEndpointMapper INSTANCE = new ConnectionEndpointMapper();
    }
    public static ConnectionEndpointMapper getInstance(IGCVersionEnum version) {
        return Singleton.INSTANCE;
    }

    // Note that we need to use the 'data_connectors' link because the 'host' attribute on data_connection assets
    // is always empty (it is through the 'data_connectors' relationship that we'll determine the host)
    protected ConnectionEndpointMapper() {
        super(
                "host",
                "data_connection",
                "data_connections",
                "data_connectors",
                "ConnectionEndpoint",
                "connectionEndpoint",
                "connections"
        );
        setOptimalStart(OptimalStart.CUSTOM);
        setLinkingAssetType("connector");
    }

    /**
     * Retrieve the host asset expected from a connector asset.
     *
     * @param connectorAsset the connector asset to translate into a host asset
     * @param igcRestClient REST connectivity to the IGC environment
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @return Reference - the host asset
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    @Override
    public List<Reference> getProxyOneAssetFromAsset(Reference connectorAsset, IGCRestClient igcRestClient, ObjectCache cache) throws RepositoryErrorException {
        final String methodName = "getProxyOneAssetFromAsset";
        String otherAssetType = connectorAsset.getType();
        ArrayList<Reference> asList = new ArrayList<>();
        if (otherAssetType.equals("connector")) {
            try {
                Reference withHost = igcRestClient.getAssetWithSubsetOfProperties(
                        connectorAsset.getId(),
                        connectorAsset.getType(),
                        new String[]{"host", "data_connections"});
                asList.add((Reference) igcRestClient.getPropertyByName(withHost, "host"));
            } catch (IGCException e) {
                raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
            }
        } else {
            log.debug("Not a connector asset, just returning as-is: {} of type {}", connectorAsset.getName(), connectorAsset.getType());
            asList.add(connectorAsset);
        }
        return asList;
    }

    /**
     * Retrieve the data_connection asset expected from a connector asset.
     *
     * @param connectorAsset the connector asset to translate into a data_connection asset
     * @param igcRestClient REST connectivity to the IGC environment
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @return Reference - the data_connection asset
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    @Override
    public List<Reference> getProxyTwoAssetFromAsset(Reference connectorAsset, IGCRestClient igcRestClient, ObjectCache cache) throws RepositoryErrorException {
        final String methodName = "getProxyTwoAssetFromAsset";
        if (connectorAsset != null && connectorAsset.getType().equals("connector")) {
            try {
                Connector withDataConnections = igcRestClient.getAssetWithSubsetOfProperties(
                        connectorAsset.getId(),
                        connectorAsset.getType(),
                        new String[]{"host", "data_connections"});
                ItemList<DataConnection> dataConnections = withDataConnections.getDataConnections();
                return new ArrayList<>(igcRestClient.getAllPages("data_connections", dataConnections));
            } catch (IGCException e) {
                raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
            }
            return Collections.emptyList();
        } else if (connectorAsset != null) {
            log.debug("Not a connector asset, just returning as-is: {} of type {}", connectorAsset.getName(), connectorAsset.getType());
            List<Reference> referenceAsList = new ArrayList<>();
            referenceAsList.add(connectorAsset);
            return referenceAsList;
        } else {
            log.warn("Received a null object, returning an empty list.");
            return Collections.emptyList();
        }
    }

    /**
     * Custom implementation of the relationship between an Endpoint (host) and a Connection (data_connection).
     * The relationship itself in IGC is complicated, from the host end it requires multiple hops (as the
     * 'data_connections' property on the host actually points to 'connector' assets, not 'data_connection' assets).
     *
     * @param igcomrsRepositoryConnector connectivity to the IGC environment
     * @param relationships the list of relationships to which to add
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param fromIgcObject the host asset for which to create the relationship
     * @param toIgcObject the other entity endpoint for the relationship (or null if unknown)
     * @param fromRelationshipElement the starting element number of the relationships to return.
     *                                This is used when retrieving elements
     *                                beyond the first page of results. Zero means start from the first element.
     * @param sequencingOrder Enum defining how the results should be ordered.
     * @param pageSize the maximum number of result classifications that can be returned on this request.  Zero means
     *                 unrestricted return results size.
     * @param userId the user ID requesting the mapped relationships
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    @Override
    public void addMappedOMRSRelationships(IGCOMRSRepositoryConnector igcomrsRepositoryConnector,
                                           List<Relationship> relationships,
                                           ObjectCache cache,
                                           Reference fromIgcObject,
                                           Reference toIgcObject,
                                           int fromRelationshipElement,
                                           SequencingOrder sequencingOrder,
                                           int pageSize,
                                           String userId) throws RepositoryErrorException {

        String assetType = IGCRestConstants.getAssetTypeForSearch(fromIgcObject.getType());

        if (assetType.equals("host")) {
            addMappedOMRSRelationships_host(
                    igcomrsRepositoryConnector,
                    relationships,
                    cache,
                    fromIgcObject,
                    fromRelationshipElement,
                    sequencingOrder,
                    pageSize,
                    userId
            );
        } else if (assetType.equals("data_connection")) {
            addMappedOMRSRelationships_connection(
                    igcomrsRepositoryConnector,
                    relationships,
                    cache,
                    fromIgcObject,
                    fromRelationshipElement,
                    sequencingOrder,
                    pageSize,
                    userId
            );
        } else if (assetType.equals("connector")) {
            List<Reference> connections = getProxyTwoAssetFromAsset(fromIgcObject, igcomrsRepositoryConnector.getIGCRestClient(), cache);
            for (Reference connection : connections) {
                addMappedOMRSRelationships_connection(
                        igcomrsRepositoryConnector,
                        relationships,
                        cache,
                        connection,
                        fromRelationshipElement,
                        sequencingOrder,
                        pageSize,
                        userId
                );
            }
        } else {
            log.warn("Found unexpected asset type during relationship mapping: {}", fromIgcObject);
        }

    }

    /**
     * Custom implementation of the relationship between an Endpoint (host) and a Connection (data_connection).
     * The relationship itself in IGC is complicated, from the host end it requires multiple hops (as the
     * 'data_connections' property on the host actually points to 'connector' assets, not 'data_connection' assets).
     *
     * @param igcomrsRepositoryConnector connectivity to the IGC environment
     * @param relationships the list of relationships to which to add
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param fromIgcObject the host asset for which to create the relationship
     * @param fromRelationshipElement the starting element number of the relationships to return.
     *                                This is used when retrieving elements
     *                                beyond the first page of results. Zero means start from the first element.
     * @param sequencingOrder Enum defining how the results should be ordered.
     * @param pageSize the maximum number of result classifications that can be returned on this request.  Zero means
     *                 unrestricted return results size.
     * @param userId the user requesting mapped relationships
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    private void addMappedOMRSRelationships_host(IGCOMRSRepositoryConnector igcomrsRepositoryConnector,
                                                 List<Relationship> relationships,
                                                 ObjectCache cache,
                                                 Reference fromIgcObject,
                                                 int fromRelationshipElement,
                                                 SequencingOrder sequencingOrder,
                                                 int pageSize,
                                                 String userId) throws RepositoryErrorException {

        final String methodName = "addMappedOMRSRelationships_host";
        IGCSearchCondition igcSearchCondition = new IGCSearchCondition("data_connectors.host", "=", fromIgcObject.getId());
        IGCSearchConditionSet igcSearchConditionSet = new IGCSearchConditionSet(igcSearchCondition);
        String[] properties = new String[]{ "name" };
        IGCSearch igcSearch = new IGCSearch("data_connection", properties, igcSearchConditionSet);

        IGCSearchSorting sorting = IGCRepositoryHelper.sortFromNonPropertySequencingOrder(sequencingOrder);
        if (sorting != null) {
            igcSearch.addSortingCriteria(sorting);
        }
        if (pageSize > 0) {
            igcSearch.setPageSize(fromRelationshipElement + pageSize);
        }

        try {
            ItemList<DataConnection> dataConnections = igcomrsRepositoryConnector.getIGCRestClient().search(igcSearch);
            if (pageSize == 0) {
                List<DataConnection> allPages = igcomrsRepositoryConnector.getIGCRestClient().getAllPages(null, dataConnections);
                dataConnections.setAllPages(allPages);
            }

            for (Reference dataConnection : dataConnections.getItems()) {

                /* Only proceed with the connection object if it is not a 'main_object' asset
                 * (in this scenario, 'main_object' represents ColumnAnalysisMaster objects that are not accessible
                 *  and will throw bad request (400) REST API errors) */
                if (dataConnection != null && !dataConnection.getType().equals(IGCRepositoryHelper.DEFAULT_IGC_TYPE)) {
                    log.debug("Retrieved connection: {} of type {}", dataConnection.getName(), dataConnection.getType());
                    Relationship relationship = getMappedRelationship(
                            igcomrsRepositoryConnector,
                            ConnectionEndpointMapper.getInstance(igcomrsRepositoryConnector.getIGCVersion()),
                            (RelationshipDef) igcomrsRepositoryConnector.getRepositoryHelper().getTypeDefByName(
                                    igcomrsRepositoryConnector.getRepositoryName(),
                                    "ConnectionEndpoint"),
                            cache,
                            fromIgcObject,
                            dataConnection,
                            "data_connections",
                            userId
                    );
                    relationships.add(relationship);
                }

            }
        } catch (IGCException e) {
            raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
        }

    }

    /**
     * Custom implementation of the relationship between an Endpoint (host) and a Connection (data_connection).
     * The relationship itself in IGC is complicated, from this end it requires retrieving the host details from
     * the 'connector' object related through the 'data_connectors' property, as the 'host' property on'data_connection'
     * itself is inevitably blank.
     *
     * @param igcomrsRepositoryConnector connectivity to the IGC environment
     * @param relationships the list of relationships to which to add
     * @param cache a cache of information that may already have been retrieved about the provided object
     * @param fromIgcObject the data_connection object for which to create the relationship
     * @param fromRelationshipElement the starting element number of the relationships to return.
     *                                This is used when retrieving elements
     *                                beyond the first page of results. Zero means start from the first element.
     * @param sequencingOrder Enum defining how the results should be ordered.
     * @param pageSize the maximum number of result classifications that can be returned on this request.  Zero means
     *                 unrestricted return results size.
     * @param userId the user requesting the mapped relationships
     * @throws RepositoryErrorException if any issue interacting with IGC
     */
    private void addMappedOMRSRelationships_connection(IGCOMRSRepositoryConnector igcomrsRepositoryConnector,
                                                       List<Relationship> relationships,
                                                       ObjectCache cache,
                                                       Reference fromIgcObject,
                                                       int fromRelationshipElement,
                                                       SequencingOrder sequencingOrder,
                                                       int pageSize,
                                                       String userId) throws RepositoryErrorException {

        final String methodName = "addMappedOMRSRElationships_connection";
        IGCRestClient igcRestClient = igcomrsRepositoryConnector.getIGCRestClient();
        IGCSearchCondition igcSearchCondition = new IGCSearchCondition("data_connections", "=", fromIgcObject.getId());
        IGCSearchConditionSet igcSearchConditionSet = new IGCSearchConditionSet(igcSearchCondition);
        String[] properties = new String[]{ "host" };
        IGCSearch igcSearch = new IGCSearch("connector", properties, igcSearchConditionSet);

        IGCSearchSorting sorting = IGCRepositoryHelper.sortFromNonPropertySequencingOrder(sequencingOrder);
        if (sorting != null) {
            igcSearch.addSortingCriteria(sorting);
        }
        if (pageSize > 0) {
            igcSearch.setPageSize(fromRelationshipElement + pageSize);
        }

        try {
            ItemList<Connector> dataConnectors = igcomrsRepositoryConnector.getIGCRestClient().search(igcSearch);
            if (pageSize == 0) {
                List<Connector> allPages = igcomrsRepositoryConnector.getIGCRestClient().getAllPages(null, dataConnectors);
                dataConnectors.setAllPages(allPages);
            }

            for (Reference dataConnector : dataConnectors.getItems()) {

                /* Only proceed with the connector object if it is not a 'main_object' asset
                 * (in this scenario, 'main_object' represents ColumnAnalysisMaster objects that are not accessible
                 *  and will throw bad request (400) REST API errors) */
                if (dataConnector != null && !dataConnector.getType().equals(IGCRepositoryHelper.DEFAULT_IGC_TYPE)) {
                    log.debug("Retrieved connector: {} of type {}", dataConnector.getName(), dataConnector.getType());
                    //Reference host = (Reference) connectorGetPropertyByName.invoke(dataConnector, "host");
                    Reference host = (Reference) igcRestClient.getPropertyByName(dataConnector, "host");
                    log.debug("Retrieved host: {} of type {}", host.getName(), host.getType());

                    Relationship relationship = getMappedRelationship(
                            igcomrsRepositoryConnector,
                            ConnectionEndpointMapper.getInstance(igcomrsRepositoryConnector.getIGCVersion()),
                            (RelationshipDef) igcomrsRepositoryConnector.getRepositoryHelper().getTypeDefByName(
                                    igcomrsRepositoryConnector.getRepositoryName(),
                                    "ConnectionEndpoint"),
                            cache,
                            host,
                            fromIgcObject,
                            "data_connections",
                            userId
                    );

                    relationships.add(relationship);

                }

            }

        } catch (IGCException e) {
            raiseRepositoryErrorException(IGCOMRSErrorCode.UNKNOWN_RUNTIME_ERROR, methodName, e);
        }

    }

}
