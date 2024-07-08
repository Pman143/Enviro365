package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.OrganizationDto;
import com.enviro.assessment.senior001.princesemenya.dto.ResponseDto;
import com.enviro.assessment.senior001.princesemenya.dto.SuggestionDto;
import com.enviro.assessment.senior001.princesemenya.service.IOrganizationService;
import com.enviro.assessment.senior001.princesemenya.service.OpenApiService;
import com.enviro.assessment.senior001.princesemenya.service.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/organization")
@Slf4j
@Tag(name = "Organization", description = "API for managing organizations")
@SecurityRequirement(name = "bearerAuth")
public class OrganizationController {

    private final IOrganizationService organizationService;
    private final OpenApiService openAIService;

    public OrganizationController(IOrganizationService organizationService, OpenApiService openAIService) {
        this.organizationService = organizationService;
        this.openAIService = openAIService;
    }

    @GetMapping("/{organizationId}")
    @PreAuthorize("@organizationServiceImpl.hasAccessToOrganization(#organizationId, #userDetails)")
    @Operation(summary = "Get an organization by its ID")
    public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable String organizationId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.info("getOrganizationById {}", organizationId);
        return ResponseEntity.ok(organizationService.getOrganizationById(organizationId));
    }

    @GetMapping
    @Operation(summary = "Get all organizations")
    public ResponseEntity<List<OrganizationDto>> getOrganizations() {
        log.info("getOrganizations");
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @PostMapping
    @Operation(summary = "Create a new organization")
    public ResponseEntity<ResponseDto> createOrganization(@RequestBody OrganizationDto organizationDto) throws URISyntaxException {
        log.info("createOrganization {}", organizationDto);
        String organizationId = organizationService.saveOrganization(organizationDto);
        URI location = new URI("/api/v1/organization/" + organizationId);
        return ResponseEntity.created(location)
                .body(new ResponseDto(String.valueOf(HttpStatus.CREATED.value()), organizationId));
    }

    @GetMapping("/{externalId}/suggestions")
    @Operation(summary = "This service is used to get a list of suggesting in which an organization can make informed decisions and drive positive environmental outcomes")
    public ResponseEntity<SuggestionDto> getSuggestions(@PathVariable String externalId) {
        OrganizationDto organizationDTO = organizationService.getOrganizationById(externalId);
        if (organizationDTO != null) {
            List<String> suggestions = openAIService.getSuggestions(organizationDTO.name(), organizationDTO.industry());
            return new ResponseEntity<>(new SuggestionDto(externalId, suggestions), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
