package com.fiap.reservarest.application.entrypoint.rest.rating.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class RatingRequestDTO {

    @JsonProperty("restaurant_id")
    private UUID restaurantId;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("comment")
    private String comment;

}
