package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.EmissionDto;
import com.enviro.assessment.senior001.princesemenya.dto.ResponseDto;
import com.enviro.assessment.senior001.princesemenya.service.IEmissionService;
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
@RequestMapping("/api/v1/emissions")
@Slf4j
@Tag(name = "Emission", description = "API for managing emissions")
@SecurityRequirement(name = "bearerAuth")
public class EmissionController {

    private final IEmissionService emissionService;

    public EmissionController(IEmissionService emissionService) {
        this.emissionService = emissionService;
    }

    @GetMapping("/{emissionId}")
    @Operation(summary = "Get an emission by its ID")
    public ResponseEntity<EmissionDto> getEmissionById(@PathVariable String emissionId) {
        log.info("getEmissionById {}", emissionId);
        return ResponseEntity.ok(emissionService.getEmissionById(emissionId));
    }

    @GetMapping
    @Operation(summary = "Get all emissions")
    public ResponseEntity<List<EmissionDto>> getEmissions() {
        log.info("getEmissions");
        return ResponseEntity.ok(emissionService.getAllEmissions());
    }

    @PostMapping
    @Operation(summary = "Create a new emission")
    public ResponseEntity<ResponseDto> createEmission(@RequestBody EmissionDto emissionDto) throws URISyntaxException {
        log.info("createEmission {}", emissionDto);
        String emissionId = emissionService.saveEmission(emissionDto);
        URI location = new URI("/api/v1/emissions/" + emissionId);
        return ResponseEntity.created(location)
                .body(new ResponseDto(String.valueOf(HttpStatus.CREATED.value()), emissionId));
    }
}
