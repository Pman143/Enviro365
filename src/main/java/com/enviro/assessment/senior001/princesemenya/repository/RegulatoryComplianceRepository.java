package com.enviro.assessment.senior001.princesemenya.repository;

import com.enviro.assessment.senior001.princesemenya.entity.RegulatoryCompliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RegulatoryComplianceRepository extends JpaRepository<RegulatoryCompliance, UUID> {

    Optional<RegulatoryCompliance> findByExternalId(String externalId);
}
