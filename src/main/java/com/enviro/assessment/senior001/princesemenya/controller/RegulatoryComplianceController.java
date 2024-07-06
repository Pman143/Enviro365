package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.RegulatoryComplianceDto;
import com.enviro.assessment.senior001.princesemenya.dto.ResponseDto;
import com.enviro.assessment.senior001.princesemenya.service.IRegulatoryComplianceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/regulatory-compliances")
@Slf4j
@Tag(name = "Regulatory Compliance", description = "API for managing regulatory compliance")
public class RegulatoryComplianceController {

    private final IRegulatoryComplianceService regulatoryComplianceService;

    public RegulatoryComplianceController(IRegulatoryComplianceService regulatoryComplianceService) {
        this.regulatoryComplianceService = regulatoryComplianceService;
    }

    @GetMapping("/{regulatoryComplianceId}")
    @Operation(summary = "Get a regulatory compliance by its ID")
    public ResponseEntity<RegulatoryComplianceDto> getRegulatoryComplianceById(@PathVariable String regulatoryComplianceId) {
        log.info("getRegulatoryComplianceById {}", regulatoryComplianceId);
        return ResponseEntity.ok(regulatoryComplianceService.getRegulatoryComplianceById(regulatoryComplianceId));
    }

    @GetMapping
    @Operation(summary = "Get all regulatory compliance")
    public ResponseEntity<List<RegulatoryComplianceDto>> getRegulatoryCompliances() {
        log.info("getRegulatoryCompliances");
        return ResponseEntity.ok(regulatoryComplianceService.getAllRegulatoryCompliances());
    }

    @PostMapping
    @Operation(summary = "Create a new regulatory compliance")
    public ResponseEntity<ResponseDto> createRegulatoryCompliance(@RequestBody RegulatoryComplianceDto regulatoryComplianceDto) throws URISyntaxException {
        log.info("createRegulatoryCompliance {}", regulatoryComplianceDto);
        String regulatoryComplianceId = regulatoryComplianceService.saveRegulatoryCompliance(regulatoryComplianceDto);
        URI location = new URI("/api/v1/regulatory-compliances/" + regulatoryComplianceId);
        return ResponseEntity.created(location)
                .body(new ResponseDto(String.valueOf(HttpStatus.CREATED.value()), regulatoryComplianceId));
    }
}
