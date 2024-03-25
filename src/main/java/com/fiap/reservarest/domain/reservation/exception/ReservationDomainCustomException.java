package com.fiap.reservarest.domain.reservation.exception;

public class ReservationDomainCustomException extends IllegalArgumentException {

    private final String message;

    public ReservationDomainCustomException(String message) {
        super(message);
        this.message = message;
    }
}
