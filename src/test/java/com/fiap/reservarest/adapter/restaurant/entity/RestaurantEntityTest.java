package com.fiap.reservarest.adapter.restaurant.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RestaurantEntityTest {

    private RestaurantEntity restaurantEntity;

    @BeforeEach
    void setUp() {
        restaurantEntity = new RestaurantEntity();
    }

    @Test
    void shouldCreateEmptyRestaurantEntityWithNoArgsConstructor() {
        assertNull(restaurantEntity.getId());
        assertNull(restaurantEntity.getExternalId());
        assertNull(restaurantEntity.getName());
        assertNull(restaurantEntity.getLocation());
        assertNull(restaurantEntity.getCuisineType());
        assertNull(restaurantEntity.getHoursOfOperation());
        assertNull(restaurantEntity.getCapacity());
        assertNull(restaurantEntity.getCreateAt());
    }

    @Test
    void shouldSetAndReturnValuesCorrectly() {
        UUID externalId = UUID.randomUUID();
        String name = "Test Restaurant";
        String location = "Test Location";
        String cuisineType = "Test Cuisine";
        Double hoursOfOperation = 10.0;
        Integer capacity = 100;
        LocalDateTime createAt = LocalDateTime.now();

        restaurantEntity = new RestaurantEntity(externalId, name, location, cuisineType, hoursOfOperation, capacity, createAt);

        assertEquals(externalId, restaurantEntity.getExternalId());
        assertEquals(name.toLowerCase(), restaurantEntity.getName());
        assertEquals(location.toLowerCase(), restaurantEntity.getLocation());
        assertEquals(cuisineType.toLowerCase(), restaurantEntity.getCuisineType());
        assertEquals(hoursOfOperation, restaurantEntity.getHoursOfOperation());
        assertEquals(capacity, restaurantEntity.getCapacity());
        assertEquals(createAt, restaurantEntity.getCreateAt());
    }
}