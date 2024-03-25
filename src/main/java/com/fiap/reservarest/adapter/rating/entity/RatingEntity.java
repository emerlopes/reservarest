package com.fiap.reservarest.adapter.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;
    private UUID restaurantId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    public RatingEntity(
            final UUID restaurantId,
            final Integer rating,
            final String comment,
            final LocalDateTime createdAt
    ) {
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public RatingEntity() {

    }
}
