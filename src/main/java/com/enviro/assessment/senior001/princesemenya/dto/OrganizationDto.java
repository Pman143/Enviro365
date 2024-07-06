package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record OrganizationDto(@JsonIgnore String id, String name, String industry, String location, LocalDateTime establishedDate) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
