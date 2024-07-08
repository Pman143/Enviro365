package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record SustainabilityInitiativeDto(@JsonIgnore @Schema(hidden = true) String id, String name, String description, String impactMeasure, String organizationId) {
    @JsonProperty
    @Schema(description = "The unique identifier of the organization", accessMode = Schema.AccessMode.READ_ONLY)
    public String id() {
        return id;
    }
}
