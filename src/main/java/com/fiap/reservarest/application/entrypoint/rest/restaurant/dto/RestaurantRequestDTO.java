package com.fiap.reservarest.application.entrypoint.rest.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RestaurantRequestDTO(
        @NotBlank(message = "Name is required")
        @Size(min = 3, max = 100, message = "Name must be between 2 and 100 characters")
        String name,
        @NotBlank(message = "Location is required")
        String location,
        @JsonProperty("cuisine_type")
        @NotBlank(message = "Cuisine type is required")
        String cuisineType,
        @JsonProperty("hours_of_operation")
        @NotNull(message = "Hours of operation is required")
        @Positive(message = "Hours of operation must be positive")
        Double hoursOfOperation,
        @NotNull(message = "Capacity is required")
        @Positive(message = "Capacity must be positive")
        Integer capacity
) {
}