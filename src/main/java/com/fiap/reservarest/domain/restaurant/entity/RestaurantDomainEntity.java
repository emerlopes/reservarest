package com.fiap.reservarest.domain.restaurant.entity;

import com.fiap.reservarest.domain.restaurant.exception.RestaurantDomainCustomException;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

public class RestaurantDomainEntity {

    private Long id;
    private UUID externalId;
    private String name;
    private String location;
    private String cuisineType;
    private Double hoursOfOperation;

    @Setter
    private Integer capacity;
    private LocalDateTime createAt;

    public RestaurantDomainEntity() {
    }

    public RestaurantDomainEntity(
            final Long id,
            final UUID externalId,
            final String name,
            final String location,
            final String cuisineType,
            final Double hoursOfOperation,
            final Integer capacity,
            final LocalDateTime createAt
    ) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType;
        this.hoursOfOperation = hoursOfOperation;
        this.capacity = capacity;
        this.createAt = createAt;

        validate();
    }

    public RestaurantDomainEntity(
            final UUID externalId,
            final String name,
            final String location,
            final String cuisineType,
            final Double hoursOfOperation,
            final Integer capacity,
            final LocalDateTime createAt) {
        this.externalId = externalId;
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType;
        this.hoursOfOperation = hoursOfOperation;
        this.capacity = capacity;
        this.createAt = createAt;

        validate();
    }

    public Long getId() {
        return id;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public Double getHoursOfOperation() {
        return hoursOfOperation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    private void validate() {
        if (name == null || name.isEmpty()) {
            throw new RestaurantDomainCustomException("Name cannot be null or empty");
        }
        if (location == null || location.isEmpty()) {
            throw new RestaurantDomainCustomException("Location cannot be null or empty");
        }
        if (cuisineType == null || cuisineType.isEmpty()) {
            throw new RestaurantDomainCustomException("Cuisine type cannot be null or empty");
        }
        if (hoursOfOperation == null || hoursOfOperation.isNaN() || hoursOfOperation <= 0) {
            throw new RestaurantDomainCustomException("Hours of operation cannot be null or less than or equal to 0");
        }
        if (capacity == null || capacity <= 0) {
            throw new RestaurantDomainCustomException("Capacity cannot be null or less than or equal to 0");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", external_id:" + externalId +
                ", name:'" + name + '\'' +
                ", location:'" + location + '\'' +
                ", cuisine_type:'" + cuisineType + '\'' +
                ", hours_of_operation:" + hoursOfOperation +
                ", capacity:" + capacity +
                ", createAt:" + createAt +
                '}';
    }
}
