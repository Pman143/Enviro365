package com.enviro.assessment.senior001.princesemenya.enums;

import lombok.Getter;

@Getter
public enum EmmissionSource {

    FACTORY("Factory"),
    AGRICULTURE("Agriculture"),
    TRANSPORT("Transport"),
    ENERGY_PRODUCTION("Energy Production"),
    WASTE_MANAGEMENT("Waste Management"),
    INDUSTRIAL_PROCESSES("Industrial Processes"),
    CONSTRUCTION("Construction");

    private final String description;

    EmmissionSource(String description) {
        this.description = description;
    }

}
