package com.enviro.assessment.senior001.princesemenya.dto;

import com.enviro.assessment.senior001.princesemenya.enums.EmissionType;
import com.enviro.assessment.senior001.princesemenya.enums.EmmissionSource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record EmissionDto(@JsonIgnore @Schema(hidden = true) String id, LocalDate date, EmissionType type, double amount, EmmissionSource source, String organizationId) {
    @JsonProperty
    @Schema(description = "The unique identifier of the emission", accessMode = Schema.AccessMode.READ_ONLY)
    public String id() {
        return id;
    }
}
