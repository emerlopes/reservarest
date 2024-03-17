package com.fiap.reservarest.application.entrypoint.rest.rating.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RatingResponseDTOTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        Long ratingId = 1L;
        UUID restaurantId = UUID.randomUUID();
        Integer rating = 5;
        String comment = "Great restaurant";
        LocalDateTime createdAt = LocalDateTime.now();

        // Act
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO(ratingId, restaurantId, rating, comment, createdAt);

        // Assert
        assertThat(ratingResponseDTO.getRatingId()).isEqualTo(ratingId);
        assertThat(ratingResponseDTO.getRestaurantId()).isEqualTo(restaurantId);
        assertThat(ratingResponseDTO.getRating()).isEqualTo(rating);
        assertThat(ratingResponseDTO.getComment()).isEqualTo(comment);
        assertThat(ratingResponseDTO.getCreatedAt()).isEqualTo(createdAt);
    }

    @Test
    public void testSetters() {
        // Arrange
        RatingResponseDTO ratingResponseDTO = new RatingResponseDTO(null, null, null, null, null);
        Long ratingId = 1L;
        UUID restaurantId = UUID.randomUUID();
        Integer rating = 5;
        String comment = "Great restaurant";
        LocalDateTime createdAt = LocalDateTime.now();

        // Act
        ratingResponseDTO.setRatingId(ratingId);
        ratingResponseDTO.setRestaurantId(restaurantId);
        ratingResponseDTO.setRating(rating);
        ratingResponseDTO.setComment(comment);
        ratingResponseDTO.setCreatedAt(createdAt);

        // Assert
        assertThat(ratingResponseDTO.getRatingId()).isEqualTo(ratingId);
        assertThat(ratingResponseDTO.getRestaurantId()).isEqualTo(restaurantId);
        assertThat(ratingResponseDTO.getRating()).isEqualTo(rating);
        assertThat(ratingResponseDTO.getComment()).isEqualTo(comment);
        assertThat(ratingResponseDTO.getCreatedAt()).isEqualTo(createdAt);
    }
}