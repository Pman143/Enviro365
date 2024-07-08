package com.enviro.assessment.senior001.princesemenya.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record OrganizationDto(@JsonIgnore String id, String name, String industry, String location) {
    @JsonProperty
    public String getId() {
        return id;
    }
}
