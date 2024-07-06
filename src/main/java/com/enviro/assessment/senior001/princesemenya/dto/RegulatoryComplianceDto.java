package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RegulatoryComplianceDto(@JsonIgnore String id, String name, String compliantStatus, String organizationId) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
