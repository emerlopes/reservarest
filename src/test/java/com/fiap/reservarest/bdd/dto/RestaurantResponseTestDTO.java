package com.fiap.reservarest.bdd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantResponseTestDTO(
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
