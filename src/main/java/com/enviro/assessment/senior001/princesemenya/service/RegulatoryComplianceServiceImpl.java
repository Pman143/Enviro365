package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.RegulatoryComplianceDto;
import com.enviro.assessment.senior001.princesemenya.entity.RegulatoryCompliance;
import com.enviro.assessment.senior001.princesemenya.exceptions.RegulatoryComplianceNotFoundException;
import com.enviro.assessment.senior001.princesemenya.mapper.RegulatoryComplianceMapper;
import com.enviro.assessment.senior001.princesemenya.repository.RegulatoryComplianceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegulatoryComplianceServiceImpl implements IRegulatoryComplianceService {

    private final RegulatoryComplianceRepository regulatoryComplianceRepository;
    private final RegulatoryComplianceMapper regulatoryComplianceMapper = RegulatoryComplianceMapper.INSTANCE;

    public RegulatoryComplianceServiceImpl(RegulatoryComplianceRepository regulatoryComplianceRepository) {
        this.regulatoryComplianceRepository = regulatoryComplianceRepository;
    }

    @Override
    public List<RegulatoryComplianceDto> getAllRegulatoryCompliances() {
        return regulatoryComplianceRepository.findAll()
                .stream()
                .map(regulatoryComplianceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RegulatoryComplianceDto getRegulatoryComplianceById(String id) {
        RegulatoryCompliance regulatoryCompliance = regulatoryComplianceRepository.findByExternalId(id)
                .orElseThrow(() -> new RegulatoryComplianceNotFoundException("Regulatory compliance not found with id " + id));
        return regulatoryComplianceMapper.toDto(regulatoryCompliance);
    }

    @Override
    public String saveRegulatoryCompliance(RegulatoryComplianceDto regulatoryComplianceDto) {
        RegulatoryCompliance regulatoryCompliance = regulatoryComplianceMapper.toEntity(regulatoryComplianceDto);
        regulatoryComplianceRepository.save(regulatoryCompliance);
        return regulatoryCompliance.getExternalId();
    }
}
