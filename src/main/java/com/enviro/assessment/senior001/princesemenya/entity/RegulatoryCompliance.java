package com.enviro.assessment.senior001.princesemenya.entity;

import com.enviro.assessment.senior001.princesemenya.enums.CompliantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegulatoryCompliance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(unique = true)
    private String externalId = UUID.randomUUID().toString();

    private String name;

    @Enumerated(EnumType.STRING)
    private CompliantStatus compliantStatus;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
}
