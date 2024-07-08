package com.enviro.assessment.senior001.princesemenya.repository;

import com.enviro.assessment.senior001.princesemenya.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    Optional<User> findUserByExternalId(String id);

    Boolean existsByEmail(String email);
}