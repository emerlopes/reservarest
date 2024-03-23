package com.fiap.reservarest.application.exception;

import com.fiap.reservarest.domain.reservation.exception.ReservationDomainCustomException;
import com.fiap.reservarest.domain.restaurant.exception.RestaurantDomainCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleException() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid fields");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ReservationDomainCustomException.class)
    public ResponseEntity<Map<String, Object>> handleExceptionBookingTable(
            ReservationDomainCustomException exception
    ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(RestaurantDomainCustomException.class)
    public ResponseEntity<Map<String, Object>> handleExceptionBookingTable(
            RestaurantDomainCustomException exception
    ) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
