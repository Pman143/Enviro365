package com.enviro.assessment.senior001.princesemenya.mapper;

import com.enviro.assessment.senior001.princesemenya.dto.EmissionDto;
import com.enviro.assessment.senior001.princesemenya.entity.Emission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmissionMapper {

    EmissionMapper INSTANCE = Mappers.getMapper(EmissionMapper.class);

    Emission toEntity(EmissionDto emissionDto);

    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "id", source = "externalId")
    EmissionDto toDto(Emission emission);
}
