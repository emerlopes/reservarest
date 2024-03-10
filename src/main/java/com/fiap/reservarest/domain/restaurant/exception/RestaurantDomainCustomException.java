package com.fiap.reservarest.domain.restaurant.exception;

public class RestaurantDomainCustomException extends IllegalArgumentException {

    private String message;

    public RestaurantDomainCustomException(String message) {
        super(message);
        this.message = message;
    }
}
