package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.OrganizationDto;
import com.enviro.assessment.senior001.princesemenya.entity.Organization;
import com.enviro.assessment.senior001.princesemenya.exceptions.OrganizationNotFoundException;
import com.enviro.assessment.senior001.princesemenya.mapper.OrganizationMapper;
import com.enviro.assessment.senior001.princesemenya.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper = OrganizationMapper.INSTANCE;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    @Override
    public List<OrganizationDto> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(organizationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDto getOrganizationById(String id) {
        Organization organization;
        try {
            organization = organizationRepository.findByExternalId(id)
                    .orElseThrow(() -> new OrganizationNotFoundException("Organization not found with id " + id));
            return organizationMapper.toDto(organization);
        } catch (IllegalArgumentException e) {
            throw new OrganizationNotFoundException("");
        }
    }

    @Override
    public String saveOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationMapper.toEntity(organizationDto);
        organizationRepository.save(organization);
        return organization.getExternalId();
    }
}
