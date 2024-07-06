package com.enviro.assessment.senior001.princesemenya.enums;

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
