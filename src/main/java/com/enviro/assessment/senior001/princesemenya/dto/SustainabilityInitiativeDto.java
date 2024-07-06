package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SustainabilityInitiativeDto(@JsonIgnore String id, String name, String description, String impactMeasure, String organizationId) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
