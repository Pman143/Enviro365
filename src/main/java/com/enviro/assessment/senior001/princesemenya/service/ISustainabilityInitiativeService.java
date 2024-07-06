package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.SustainabilityInitiativeDto;

import java.util.List;

public interface ISustainabilityInitiativeService {

    List<SustainabilityInitiativeDto> getAllSustainabilityInitiatives();
    SustainabilityInitiativeDto getSustainabilityInitiativeById(String id);
    String saveSustainabilityInitiative(SustainabilityInitiativeDto sustainabilityInitiativeDto);
}
