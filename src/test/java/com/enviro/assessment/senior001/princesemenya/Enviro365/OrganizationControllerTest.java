package com.enviro.assessment.senior001.princesemenya.controller;

import com.enviro.assessment.senior001.princesemenya.dto.OrganizationDto;
import com.enviro.assessment.senior001.princesemenya.service.IOrganizationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class OrganizationControllerTest {

    @Mock
    private IOrganizationService organizationService;

    @InjectMocks
    private OrganizationController organizationController;

    private MockMvc mockMvc;

    @Test
    void testGetOrganizationById() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(organizationController).build();
        OrganizationDto organizationDto = new OrganizationDto("1", "Test Organization", "Industry", "Location", LocalDateTime.now());

        when(organizationService.getOrganizationById("1")).thenReturn(organizationDto);

        mockMvc.perform(get("/api/v1/organization/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Organization"));
    }

    @Test
    void testGetAllOrganizations() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(organizationController).build();
        OrganizationDto organizationDto = new OrganizationDto("1", "Test Organization", "Industry", "Location", LocalDateTime.now());

        when(organizationService.getAllOrganizations()).thenReturn(Collections.singletonList(organizationDto));

        mockMvc.perform(get("/api/v1/organization")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Organization"));
    }
}
