/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.repositoryconnector.mapping.attributes;

import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EnumPropertyValue;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.typedefs.EnumElementDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * The base class for all Enum mappings between OMRS AttributeTypeDefs and IGC properties.
 */
public class EnumMapping extends AttributeMapping {

    private static final Logger log = LoggerFactory.getLogger(EnumMapping.class);

    private HashMap<String, EnumElementDef> enumDefByIgcValue;
    private HashMap<String, String> mapSymbolicNameToIgcValue;
    private EnumElementDef defaultEnum;

    /**
     * Create an enumeration mapping for the specified OMRS attribute type def.
     *
     * @param omrsAttributeTypeDefName the OMRS attribute type def for which to create the mapping
     */
    public EnumMapping(String omrsAttributeTypeDefName) {
        super(omrsAttributeTypeDefName);
        enumDefByIgcValue = new HashMap<>();
        mapSymbolicNameToIgcValue = new HashMap<>();
    }

    /**
     * Add a default enumeration mapping using the provided parameters.
     *
     * @param omrsOrdinal the default ordinal value
     * @param omrsSymbolicName the default symbolic name
     * @param description the default description
     */
    public void addDefaultEnumMapping(int omrsOrdinal, String omrsSymbolicName, String description) {
        defaultEnum = new EnumElementDef();
        defaultEnum.setOrdinal(omrsOrdinal);
        defaultEnum.setValue(omrsSymbolicName);
        defaultEnum.setDescription(description);
    }

    /**
     * Add a enumeration mapping using the provided parameters.
     *
     * @param igcValue the IGC value for the enumeration
     * @param omrsOrdinal the OMRS ordinal value
     * @param omrsSymbolicName the OMRS symbolic name
     * @param description the OMRS description
     */
    public void addEnumMapping(String igcValue, int omrsOrdinal, String omrsSymbolicName, String description) {
        EnumElementDef enumElementDef = new EnumElementDef();
        enumElementDef.setOrdinal(omrsOrdinal);
        enumElementDef.setValue(omrsSymbolicName);
        enumElementDef.setDescription(description);
        enumDefByIgcValue.put(igcValue, enumElementDef);
        mapSymbolicNameToIgcValue.put(omrsSymbolicName, igcValue);
    }

    /**
     * Retrieve the mapped OMRS enumeration from the provided IGC value.
     *
     * @param igcValue the IGC value for which to retrieve the OMRS mapped value
     * @return EnumPropertyValue
     */
    public EnumPropertyValue getEnumMappingByIgcValue(String igcValue) {
        EnumPropertyValue value = new EnumPropertyValue();
        if (enumDefByIgcValue.containsKey(igcValue)) {
            EnumElementDef element = enumDefByIgcValue.get(igcValue);
            value.setOrdinal(element.getOrdinal());
            value.setSymbolicName(element.getValue());
            value.setDescription(element.getDescription());
        } else {
            value = getDefaultEnumValue();
        }
        return value;
    }

    /**
     * Retrieve the mapped IGC value from the provided OMRS symbolic name of the enumeration (or null if there is no
     * mapping).
     *
     * @param symbolicName of the OMRS enumeration value
     * @return String giving the mapped IGC value (or null if there is no mapping)
     */
    public String getIgcValueForSymbolicName(String symbolicName) {
        return mapSymbolicNameToIgcValue.getOrDefault(symbolicName, null);
    }

    /**
     * Retrieve the default enumeration value.
     *
     * @return EnumPropertyValue
     */
    public EnumPropertyValue getDefaultEnumValue() {
        EnumPropertyValue value = new EnumPropertyValue();
        if (defaultEnum != null) {
            value.setOrdinal(defaultEnum.getOrdinal());
            value.setSymbolicName(defaultEnum.getValue());
            value.setDescription(defaultEnum.getDescription());
        } else {
            log.error("Could not find default enum value for {}.", getOmrsAttributeTypeDefName());
        }
        return value;
    }

}
