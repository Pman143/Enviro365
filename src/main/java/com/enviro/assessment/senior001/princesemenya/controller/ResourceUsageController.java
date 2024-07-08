package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.ResourceUsageDto;
import com.enviro.assessment.senior001.princesemenya.dto.ResponseDto;
import com.enviro.assessment.senior001.princesemenya.service.IResourceUsageService;
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
@RequestMapping("/api/v1/resource-usages")
@Slf4j
@Tag(name = "Resource Usage", description = "API for managing resource usage")
@SecurityRequirement(name = "bearerAuth")
public class ResourceUsageController {

    private final IResourceUsageService resourceUsageService;

    public ResourceUsageController(IResourceUsageService resourceUsageService) {
        this.resourceUsageService = resourceUsageService;
    }

    @GetMapping("/{resourceUsageId}")
    @Operation(summary = "Get a resource usage by its ID")
    public ResponseEntity<ResourceUsageDto> getResourceUsageById(@PathVariable String resourceUsageId) {
        log.info("getResourceUsageById {}", resourceUsageId);
        return ResponseEntity.ok(resourceUsageService.getResourceUsageById(resourceUsageId));
    }

    @GetMapping
    @Operation(summary = "Get all resource usage")
    public ResponseEntity<List<ResourceUsageDto>> getResourceUsages() {
        log.info("getResourceUsages");
        return ResponseEntity.ok(resourceUsageService.getAllResourceUsages());
    }

    @PostMapping
    @Operation(summary = "Create a new resource usage")
    public ResponseEntity<ResponseDto> createResourceUsage(@RequestBody ResourceUsageDto resourceUsageDto) throws URISyntaxException {
        log.info("createResourceUsage {}", resourceUsageDto);
        String resourceUsageId = resourceUsageService.saveResourceUsage(resourceUsageDto);
        URI location = new URI("/api/v1/resource-usages/" + resourceUsageId);
        return ResponseEntity.created(location)
                .body(new ResponseDto(String.valueOf(HttpStatus.CREATED.value()), resourceUsageId));
    }
}
