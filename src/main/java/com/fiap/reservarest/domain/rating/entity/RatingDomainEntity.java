package com.fiap.reservarest.domain.rating.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class RatingDomainEntity {
    private Long ratingId;
    private UUID restaurantId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    public RatingDomainEntity(
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

    public RatingDomainEntity(
            final Long ratingId,
            final UUID restaurantId,
            final Integer rating,
            final String comment,
            final LocalDateTime createdAt
    ) {
        this.ratingId = ratingId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
