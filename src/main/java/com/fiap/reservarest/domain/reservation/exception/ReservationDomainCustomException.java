package com.fiap.reservarest.domain.reservation.exception;

public class ReservationDomainCustomException extends IllegalArgumentException {

    private String message;

    public ReservationDomainCustomException(String message) {
        super(message);
        this.message = message;
    }
}
