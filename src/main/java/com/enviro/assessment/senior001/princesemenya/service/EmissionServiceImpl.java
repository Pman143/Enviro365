package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.EmissionDto;
import com.enviro.assessment.senior001.princesemenya.entity.Emission;
import com.enviro.assessment.senior001.princesemenya.exceptions.EmissionNotFoundException;
import com.enviro.assessment.senior001.princesemenya.mapper.EmissionMapper;
import com.enviro.assessment.senior001.princesemenya.repository.EmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmissionServiceImpl implements IEmissionService {

    private final EmissionRepository emissionRepository;
    private final EmissionMapper emissionMapper = EmissionMapper.INSTANCE;

    public EmissionServiceImpl(EmissionRepository emissionRepository) {
        this.emissionRepository = emissionRepository;
    }

    @Override
    public List<EmissionDto> getAllEmissions() {
        return emissionRepository.findAll()
                .stream()
                .map(emissionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmissionDto getEmissionById(String id) {
        Emission emission = emissionRepository.findByExternalId(id)
                .orElseThrow(() -> new EmissionNotFoundException("Emission not found with id " + id));
        return emissionMapper.toDto(emission);
    }

    @Override
    public String saveEmission(EmissionDto emissionDto) {
        Emission emission = emissionMapper.toEntity(emissionDto);
        emissionRepository.save(emission);
        return emission.getExternalId();
    }
}
