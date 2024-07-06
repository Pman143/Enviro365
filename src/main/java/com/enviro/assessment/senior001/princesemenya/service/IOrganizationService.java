package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.OrganizationDto;

import java.util.List;

public interface IOrganizationService {

    List<OrganizationDto> getAllOrganizations();
    OrganizationDto getOrganizationById(String id);
    String saveOrganization(OrganizationDto organization);
}
