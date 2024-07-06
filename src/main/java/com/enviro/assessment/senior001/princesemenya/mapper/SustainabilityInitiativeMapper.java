package com.enviro.assessment.senior001.princesemenya.mapper;

import com.enviro.assessment.senior001.princesemenya.dto.SustainabilityInitiativeDto;
import com.enviro.assessment.senior001.princesemenya.entity.SustainabilityInitiative;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SustainabilityInitiativeMapper {

    SustainabilityInitiativeMapper INSTANCE = Mappers.getMapper(SustainabilityInitiativeMapper.class);

    SustainabilityInitiative toEntity(SustainabilityInitiativeDto sustainabilityInitiativeDto);

    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "id", source = "externalId")
    SustainabilityInitiativeDto toDto(SustainabilityInitiative sustainabilityInitiative);
}
