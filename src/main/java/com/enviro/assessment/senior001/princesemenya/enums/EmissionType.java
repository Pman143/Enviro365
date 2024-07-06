package com.enviro.assessment.senior001.princesemenya.enums;

import lombok.Getter;

@Getter
public enum EmissionType {

    CARBON("Carbon Emission"),
    METHANE("Methane Emission"),
    NITROUS_OXIDE("Nitrous Oxide Emission");

    private final String description;

    EmissionType(String description) {
        this.description = description;
    }

}
