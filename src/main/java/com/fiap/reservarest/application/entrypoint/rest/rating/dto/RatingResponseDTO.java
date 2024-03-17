package com.fiap.reservarest.application.entrypoint.rest.rating.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class RatingResponseDTO {

    @JsonProperty("rating_id")
    private Long ratingId;

    @JsonProperty("restaurant_id")
    private UUID restaurantId;

    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;



}
