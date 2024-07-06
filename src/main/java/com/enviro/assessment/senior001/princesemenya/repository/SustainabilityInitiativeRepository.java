package com.enviro.assessment.senior001.princesemenya.repository;

import com.enviro.assessment.senior001.princesemenya.entity.SustainabilityInitiative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SustainabilityInitiativeRepository extends JpaRepository<SustainabilityInitiative, UUID> {

    Optional<SustainabilityInitiative> findByExternalId(String externalId);
}
