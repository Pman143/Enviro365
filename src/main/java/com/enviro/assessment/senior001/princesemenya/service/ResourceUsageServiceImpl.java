package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.ResourceUsageDto;
import com.enviro.assessment.senior001.princesemenya.entity.ResourceUsage;
import com.enviro.assessment.senior001.princesemenya.exceptions.ResourceUsageNotFoundException;
import com.enviro.assessment.senior001.princesemenya.mapper.ResourceUsageMapper;
import com.enviro.assessment.senior001.princesemenya.repository.ResourceUsageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceUsageServiceImpl implements IResourceUsageService {

    private final ResourceUsageRepository resourceUsageRepository;
    private final ResourceUsageMapper resourceUsageMapper = ResourceUsageMapper.INSTANCE;

    public ResourceUsageServiceImpl(ResourceUsageRepository resourceUsageRepository) {
        this.resourceUsageRepository = resourceUsageRepository;
    }

    @Override
    public List<ResourceUsageDto> getAllResourceUsages() {
        return resourceUsageRepository.findAll()
                .stream()
                .map(resourceUsageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResourceUsageDto getResourceUsageById(String id) {
        ResourceUsage resourceUsage = resourceUsageRepository.findByExternalId(id)
                .orElseThrow(() -> new ResourceUsageNotFoundException("Resource usage not found with id " + id));
        return resourceUsageMapper.toDto(resourceUsage);
    }

    @Override
    public String saveResourceUsage(ResourceUsageDto resourceUsageDto) {
        ResourceUsage resourceUsage = resourceUsageMapper.toEntity(resourceUsageDto);
        resourceUsageRepository.save(resourceUsage);
        return resourceUsage.getExternalId();
    }
}
