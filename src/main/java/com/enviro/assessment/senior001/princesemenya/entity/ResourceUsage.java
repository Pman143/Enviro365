package com.enviro.assessment.senior001.princesemenya.entity;

import com.enviro.assessment.senior001.princesemenya.enums.ResourceType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(unique = true)
    private String externalId = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private ResourceType type;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
}
