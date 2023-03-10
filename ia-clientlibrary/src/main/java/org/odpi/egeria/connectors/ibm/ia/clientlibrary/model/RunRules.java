/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.ia.clientlibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RunRules extends AbstractTask {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ExecutableRule")
    private List<ExecutableRule> executableRules;

    public List<ExecutableRule> getExecutableRules() { return executableRules; }
    public void setExecutableRules(List<ExecutableRule> executableRules) { this.executableRules = executableRules; }

    @Override
    public String toString() {
        String parent = super.toString();
        return parent.substring(0, parent.length() - 2)
                + ", \"ExecutableRules\": " + (executableRules == null ? "[]" : executableRules.toString())
                + " }";
    }

}
