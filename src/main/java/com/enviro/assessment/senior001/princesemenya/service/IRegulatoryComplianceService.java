package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.RegulatoryComplianceDto;

import java.util.List;

public interface IRegulatoryComplianceService {

    List<RegulatoryComplianceDto> getAllRegulatoryCompliances();
    RegulatoryComplianceDto getRegulatoryComplianceById(String id);
    String saveRegulatoryCompliance(RegulatoryComplianceDto regulatoryComplianceDto);
}
