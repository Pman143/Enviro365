package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.SustainabilityInitiativeDto;
import com.enviro.assessment.senior001.princesemenya.dto.ResponseDto;
import com.enviro.assessment.senior001.princesemenya.service.ISustainabilityInitiativeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sustainability-initiatives")
@Slf4j
@Tag(name = "Sustainability Initiative", description = "API for managing sustainability initiative")
@SecurityRequirement(name = "bearerAuth")
public class SustainabilityInitiativeController {

    private final ISustainabilityInitiativeService sustainabilityInitiativeService;

    public SustainabilityInitiativeController(ISustainabilityInitiativeService sustainabilityInitiativeService) {
        this.sustainabilityInitiativeService = sustainabilityInitiativeService;
    }

    @GetMapping("/{sustainabilityInitiativeId}")
    @Operation(summary = "Get a sustainability initiative by its ID")
    public ResponseEntity<SustainabilityInitiativeDto> getSustainabilityInitiativeById(@PathVariable String sustainabilityInitiativeId) {
        log.info("getSustainabilityInitiativeById {}", sustainabilityInitiativeId);
        return ResponseEntity.ok(sustainabilityInitiativeService.getSustainabilityInitiativeById(sustainabilityInitiativeId));
    }

    @GetMapping
    @Operation(summary = "Get all sustainability initiatives")
    public ResponseEntity<List<SustainabilityInitiativeDto>> getSustainabilityInitiatives() {
        log.info("getSustainabilityInitiatives");
        return ResponseEntity.ok(sustainabilityInitiativeService.getAllSustainabilityInitiatives());
    }

    @PostMapping
    @Operation(summary = "Create a new sustainability initiative")
    public ResponseEntity<ResponseDto> createSustainabilityInitiative(@RequestBody SustainabilityInitiativeDto sustainabilityInitiativeDto) throws URISyntaxException {
        log.info("createSustainabilityInitiative {}", sustainabilityInitiativeDto);
        String sustainabilityInitiativeId = sustainabilityInitiativeService.saveSustainabilityInitiative(sustainabilityInitiativeDto);
        URI location = new URI("/api/v1/sustainability-initiatives/" + sustainabilityInitiativeId);
        return ResponseEntity.created(location)
                .body(new ResponseDto(String.valueOf(HttpStatus.CREATED.value()), sustainabilityInitiativeId));
    }
}
