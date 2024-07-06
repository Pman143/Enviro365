package com.enviro.assessment.senior001.princesemenya.repository;

import com.enviro.assessment.senior001.princesemenya.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    Optional<Organization> findByExternalId(String externalId);
}
