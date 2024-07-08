package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.JwtResponse;
import com.enviro.assessment.senior001.princesemenya.dto.LoginRequestDto;
import com.enviro.assessment.senior001.princesemenya.dto.RegisterRequestDto;
import com.enviro.assessment.senior001.princesemenya.dto.ResponseDto;
import com.enviro.assessment.senior001.princesemenya.entity.Organization;
import com.enviro.assessment.senior001.princesemenya.entity.User;
import com.enviro.assessment.senior001.princesemenya.repository.UserRepository;
import com.enviro.assessment.senior001.princesemenya.service.IOrganizationService;
import com.enviro.assessment.senior001.princesemenya.service.UserDetailsImpl;
import com.enviro.assessment.senior001.princesemenya.service.jwt.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "AuthController", description = "API for managing authentication")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final IOrganizationService organizationService;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    @Operation(summary = "User login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.email(),
                        loginRequestDto.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUser().getExternalId(), userDetails.getUsername(), userDetails.getUser().getEmail()));
    }

    @PostMapping("/register")
    @Operation(summary = "User registration")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto) {
        if(userRepository.existsByEmail(registerRequestDto.email())){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseDto(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Email already taken"));
        }
        Organization organization = organizationService.getOrganizationByExternalId(registerRequestDto.organizationId());
        User user = new User(UUID.randomUUID(), UUID.randomUUID().toString(),
                registerRequestDto.username(),
                encoder.encode(registerRequestDto.password()),
                registerRequestDto.email(), organization,
                new HashSet<>()
        );
        userRepository.save(user);
        return ResponseEntity
                .ok()
                .body(new ResponseDto(String.valueOf(HttpStatus.CREATED.value()), "User registration successful"));
    }
}