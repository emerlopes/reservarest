package com.fiap.reservarest.application.entrypoint.rest.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RestaurantResponseDTO(
        @JsonProperty("external_id")
        UUID externalId,

        String name,
        String location,

        @JsonProperty("cuisine_type")
        String cuisineType,

        @JsonProperty("hours_of_operation")
        Double hoursOfOperation,

        Integer tables,

        @JsonProperty("create_at")
        LocalDateTime createAt
) {
}
