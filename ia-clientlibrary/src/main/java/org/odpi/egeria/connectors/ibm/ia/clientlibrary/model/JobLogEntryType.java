/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.ia.clientlibrary.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JobLogEntryType implements IAEnum {

    ANY("any"),
    BATCH("batch"),
    FATAL("fatal"),
    INFO("info"),
    OTHER("other"),
    REJECT("reject"),
    RESET("reset"),
    STARTED("started"),
    WARNING("warning");

    @JsonValue
    private String value;
    JobLogEntryType(String value) { this.value = value; }

    @Override
    public String getValue() { return value; }

}
