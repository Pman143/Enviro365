package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ResourceUsageDto(@JsonIgnore String id, String type, double amount, String organizationId) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
