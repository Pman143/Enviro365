package com.enviro.assessment.senior001.princesemenya.dto;

import com.enviro.assessment.senior001.princesemenya.enums.EmissionType;
import com.enviro.assessment.senior001.princesemenya.enums.EmmissionSource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record EmissionDto(@JsonIgnore String id, LocalDate date, EmissionType type, double amount, EmmissionSource source, String organizationId) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
