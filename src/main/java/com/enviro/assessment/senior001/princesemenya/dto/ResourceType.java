package com.enviro.assessment.senior001.princesemenya.dto;

import lombok.Getter;

@Getter
public enum ResourceType {

    WATER("Water"),
    ELECTRICITY("Electricity"),
    GAS("Gas");

    private final String description;

    ResourceType(String description) {
        this.description = description;
    }
}
