package com.enviro.assessment.senior001.princesemenya.entity;


import com.enviro.assessment.senior001.princesemenya.dto.EmissionType;
import com.enviro.assessment.senior001.princesemenya.dto.EmmissionSource;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(unique = true)
    private String externalId = UUID.randomUUID().toString();

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private EmissionType type;

    private double amount;

    @Enumerated(EnumType.STRING)
    private EmmissionSource source;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
}
