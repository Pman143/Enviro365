package com.enviro.assessment.senior001.princesemenya.mapper;

import com.enviro.assessment.senior001.princesemenya.dto.ResourceUsageDto;
import com.enviro.assessment.senior001.princesemenya.entity.ResourceUsage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceUsageMapper {

    ResourceUsageMapper INSTANCE = Mappers.getMapper(ResourceUsageMapper.class);

    ResourceUsage toEntity(ResourceUsageDto resourceUsageDto);

    @Mapping(target = "organizationId", source = "organization.id")
    @Mapping(target = "id", source = "externalId")
    ResourceUsageDto toDto(ResourceUsage resourceUsage);
}
