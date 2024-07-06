package com.enviro.assessment.senior001.princesemenya.mapper;

import com.enviro.assessment.senior001.princesemenya.dto.RegulatoryComplianceDto;
import com.enviro.assessment.senior001.princesemenya.entity.RegulatoryCompliance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegulatoryComplianceMapper {

    RegulatoryComplianceMapper INSTANCE = Mappers.getMapper(RegulatoryComplianceMapper.class);

    RegulatoryCompliance toEntity(RegulatoryComplianceDto regulatoryComplianceDto);

    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "id", source = "externalId")
    RegulatoryComplianceDto toDto(RegulatoryCompliance regulatoryCompliance);
}
