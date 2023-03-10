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
 * POJO for the {@code foreign_key_definition} asset type in IGC, displayed as '{@literal Foreign Key Definition}' in the IGC UI.
 * <br><br>
 * (this code has been created based on out-of-the-box IGC metadata types.
 *  If modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property="_type", visible=true, defaultImpl=ForeignKeyDefinition.class)
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeName("foreign_key_definition")
public class ForeignKeyDefinition extends Reference {

    @JsonProperty("column")
    protected String column;

    @JsonProperty("references_columns")
    protected String referencesColumns;

    @JsonProperty("references_tables")
    protected String referencesTables;

    @JsonProperty("table_definition")
    protected TableDefinition tableDefinition;

    /**
     * Retrieve the {@code column} property (displayed as '{@literal Column}') of the object.
     * @return {@code String}
     */
    @JsonProperty("column")
    public String getColumn() { return this.column; }

    /**
     * Set the {@code column} property (displayed as {@code Column}) of the object.
     * @param column the value to set
     */
    @JsonProperty("column")
    public void setColumn(String column) { this.column = column; }

    /**
     * Retrieve the {@code references_columns} property (displayed as '{@literal References Columns}') of the object.
     * @return {@code String}
     */
    @JsonProperty("references_columns")
    public String getReferencesColumns() { return this.referencesColumns; }

    /**
     * Set the {@code references_columns} property (displayed as {@code References Columns}) of the object.
     * @param referencesColumns the value to set
     */
    @JsonProperty("references_columns")
    public void setReferencesColumns(String referencesColumns) { this.referencesColumns = referencesColumns; }

    /**
     * Retrieve the {@code references_tables} property (displayed as '{@literal References Tables}') of the object.
     * @return {@code String}
     */
    @JsonProperty("references_tables")
    public String getReferencesTables() { return this.referencesTables; }

    /**
     * Set the {@code references_tables} property (displayed as {@code References Tables}) of the object.
     * @param referencesTables the value to set
     */
    @JsonProperty("references_tables")
    public void setReferencesTables(String referencesTables) { this.referencesTables = referencesTables; }

    /**
     * Retrieve the {@code table_definition} property (displayed as '{@literal Table Definition}') of the object.
     * @return {@code TableDefinition}
     */
    @JsonProperty("table_definition")
    public TableDefinition getTableDefinition() { return this.tableDefinition; }

    /**
     * Set the {@code table_definition} property (displayed as {@code Table Definition}) of the object.
     * @param tableDefinition the value to set
     */
    @JsonProperty("table_definition")
    public void setTableDefinition(TableDefinition tableDefinition) { this.tableDefinition = tableDefinition; }

}
