package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.SustainabilityInitiativeDto;
import com.enviro.assessment.senior001.princesemenya.entity.SustainabilityInitiative;
import com.enviro.assessment.senior001.princesemenya.exceptions.SustainabilityInitiativeNotFoundException;
import com.enviro.assessment.senior001.princesemenya.mapper.SustainabilityInitiativeMapper;
import com.enviro.assessment.senior001.princesemenya.repository.SustainabilityInitiativeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SustainabilityInitiativeServiceImpl implements ISustainabilityInitiativeService {

    private final SustainabilityInitiativeRepository sustainabilityInitiativeRepository;
    private final SustainabilityInitiativeMapper sustainabilityInitiativeMapper = SustainabilityInitiativeMapper.INSTANCE;

    public SustainabilityInitiativeServiceImpl(SustainabilityInitiativeRepository sustainabilityInitiativeRepository) {
        this.sustainabilityInitiativeRepository = sustainabilityInitiativeRepository;
    }

    @Override
    public List<SustainabilityInitiativeDto> getAllSustainabilityInitiatives() {
        return sustainabilityInitiativeRepository.findAll()
                .stream()
                .map(sustainabilityInitiativeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SustainabilityInitiativeDto getSustainabilityInitiativeById(String id) {
        SustainabilityInitiative sustainabilityInitiative = sustainabilityInitiativeRepository.findByExternalId(id)
                .orElseThrow(() -> new SustainabilityInitiativeNotFoundException("Sustainability initiative not found with id " + id));
        return sustainabilityInitiativeMapper.toDto(sustainabilityInitiative);
    }

    @Override
    public String saveSustainabilityInitiative(SustainabilityInitiativeDto sustainabilityInitiativeDto) {
        SustainabilityInitiative sustainabilityInitiative = sustainabilityInitiativeMapper.toEntity(sustainabilityInitiativeDto);
        sustainabilityInitiativeRepository.save(sustainabilityInitiative);
        return sustainabilityInitiative.getExternalId();
    }
}
