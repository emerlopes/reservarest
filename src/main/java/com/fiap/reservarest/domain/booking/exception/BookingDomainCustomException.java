package com.fiap.reservarest.domain.booking.exception;

public class BookingDomainCustomException extends IllegalArgumentException {

    private String message;

    public BookingDomainCustomException(String message) {
        super(message);
        this.message = message;
    }
}
