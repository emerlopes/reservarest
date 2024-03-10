package com.fiap.reservarest.application.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GlobalExceptionTest {

    private GlobalException globalException;

    @BeforeEach
    void setUp() {
        globalException = new GlobalException();
    }

    @Test
    void shouldReturnBadRequestWhenMethodArgumentNotValidExceptionOccurs() {
        // Act
        ResponseEntity<?> responseEntity = globalException.handleException();

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnErrorMessageWhenMethodArgumentNotValidExceptionOccurs() {
        // Act
        ResponseEntity<?> responseEntity = globalException.handleException();

        // Assert
        Map<String, Object> body = (Map<String, Object>) responseEntity.getBody();
        assertEquals("Invalid fields", body.get("message"));
    }

    @Test
    void shouldReturnCurrentTimestampWhenMethodArgumentNotValidExceptionOccurs() {
        // Act
        ResponseEntity<?> responseEntity = globalException.handleException();

        // Assert
        Map<String, Object> body = (Map<String, Object>) responseEntity.getBody();
        assertTrue(((LocalDateTime) body.get("timestamp")).isBefore(LocalDateTime.now()));
    }
}