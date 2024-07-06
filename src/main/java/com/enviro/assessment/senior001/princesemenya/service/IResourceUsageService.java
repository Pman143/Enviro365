package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.ResourceUsageDto;

import java.util.List;

public interface IResourceUsageService {

    List<ResourceUsageDto> getAllResourceUsages();
    ResourceUsageDto getResourceUsageById(String id);
    String saveResourceUsage(ResourceUsageDto resourceUsageDto);
}
