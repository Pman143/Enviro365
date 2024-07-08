package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ResourceUsageDto(@JsonIgnore @Schema(hidden = true) String id, String type, double amount, String organizationId) {
    @JsonProperty
    @Schema(description = "The unique identifier of the resource usage", accessMode = Schema.AccessMode.READ_ONLY)
    public String id() {
        return id;
    }
}
