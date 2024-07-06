package com.enviro.assessment.senior001.princesemenya.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(unique = true)
    private String externalId = UUID.randomUUID().toString();

    private String name;

    private String industry;

    private String location;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate establishedDate;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Emission> emissions = new ArrayList<>();
}