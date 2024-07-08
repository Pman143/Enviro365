package com.enviro.assessment.senior001.princesemenya.Enviro365;

import com.enviro.assessment.senior001.princesemenya.dto.EmissionDto;
import com.enviro.assessment.senior001.princesemenya.entity.Emission;
import com.enviro.assessment.senior001.princesemenya.enums.EmissionType;
import com.enviro.assessment.senior001.princesemenya.enums.EmmissionSource;
import com.enviro.assessment.senior001.princesemenya.exceptions.EmissionNotFoundException;
import com.enviro.assessment.senior001.princesemenya.mapper.EmissionMapper;
import com.enviro.assessment.senior001.princesemenya.repository.EmissionRepository;
import com.enviro.assessment.senior001.princesemenya.service.EmissionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmissionServiceTest {

    @Mock
    private EmissionRepository emissionRepository;

    @InjectMocks
    private EmissionServiceImpl emissionService;

    private final EmissionMapper emissionMapper = EmissionMapper.INSTANCE;

    @Test
    void testGetEmissionById() {
        UUID id = UUID.randomUUID();
        Emission emission = new Emission();
        emission.setExternalId(id.toString());
        emission.setType(EmissionType.CARBON);
        emission.setAmount(123.45);
        emission.setSource(EmmissionSource.TRANSPORT);

        when(emissionRepository.findByExternalId("externalId")).thenReturn(Optional.of(emission));

        EmissionDto emissionDto = emissionService.getEmissionById("externalId");
        assertEquals(emission.getType(), emissionDto.type());
    }

    @Test
    void testGetEmissionByIdNotFound() {
        when(emissionRepository.findByExternalId("externalId")).thenReturn(Optional.empty());
        assertThrows(EmissionNotFoundException.class, () -> emissionService.getEmissionById("externalId"));
    }

    @Test
    void testSaveEmission() {
        EmissionDto emissionDto = new EmissionDto(null,null, EmissionType.CARBON, 123.45, EmmissionSource.TRANSPORT, "organizationId");
        Emission emission = emissionMapper.toEntity(emissionDto);

        when(emissionRepository.save(any(Emission.class))).thenReturn(emission);

        String externalId = emissionService.saveEmission(emissionDto);
        assertNotNull(externalId);
    }
}
