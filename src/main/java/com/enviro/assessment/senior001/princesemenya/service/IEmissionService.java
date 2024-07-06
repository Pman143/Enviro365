package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.EmissionDto;

import java.util.List;

public interface IEmissionService {

    List<EmissionDto> getAllEmissions();
    EmissionDto getEmissionById(String id);
    String saveEmission(EmissionDto emissionDto);
}
