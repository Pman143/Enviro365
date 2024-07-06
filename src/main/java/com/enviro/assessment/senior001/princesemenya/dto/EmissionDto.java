package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record EmissionDto(@JsonIgnore String id, LocalDate date, String type, double amount, String source, String organizationId) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
