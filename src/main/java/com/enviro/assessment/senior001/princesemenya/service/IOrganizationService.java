package com.enviro.assessment.senior001.princesemenya.service;

import com.enviro.assessment.senior001.princesemenya.dto.OrganizationDto;
import com.enviro.assessment.senior001.princesemenya.entity.Organization;

import java.util.List;

public interface IOrganizationService {

    List<OrganizationDto> getAllOrganizations();
    OrganizationDto getOrganizationById(String id);
    Organization getOrganizationByExternalId(String id);
    String saveOrganization(OrganizationDto organization);
}
