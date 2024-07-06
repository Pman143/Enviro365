package com.enviro.assessment.senior001.princesemenya.repository;

import com.enviro.assessment.senior001.princesemenya.entity.ResourceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResourceUsageRepository extends JpaRepository<ResourceUsage, UUID> {

    Optional<ResourceUsage> findByExternalId(String externalId);
}
