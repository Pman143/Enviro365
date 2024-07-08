package com.enviro.assessment.senior001.princesemenya.dto;

public record JwtResponse(
        String token,
        String id,
        String username,
        String email
) {
}