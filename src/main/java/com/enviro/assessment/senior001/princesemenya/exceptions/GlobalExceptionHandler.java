package com.enviro.assessment.senior001.princesemenya.exceptions;

import com.enviro.assessment.senior001.princesemenya.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrganizationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleOrganizationAlreadyExistException(OrganizationAlreadyExistsException exception,
                                                                                WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleOrganizationNotFoundException(OrganizationNotFoundException exception,
                                                                                WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }

    @ExceptionHandler(EmissionNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEmissionNotFoundException(EmissionNotFoundException exception,
                                                                            WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }

    @ExceptionHandler(ResourceUsageNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceUsageNotFoundException(ResourceUsageNotFoundException exception,
                                                                                 WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }

    @ExceptionHandler(SustainabilityInitiativeNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleSustainabilityInitiativeNotFoundException(SustainabilityInitiativeNotFoundException exception,
                                                                                            WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }

    @ExceptionHandler(RegulatoryComplianceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleRegulatoryComplianceNotFoundException(RegulatoryComplianceNotFoundException exception,
                                                                                        WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }

    @ExceptionHandler(SuggestionsException.class)
    public ResponseEntity<ErrorResponseDto> handleRegulatoryComplianceNotFoundException(SuggestionsException exception,
                                                                                        WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, errorResponseDto.errorCode());
    }
}

