package com.fiap.reservarest.domain.restaurant.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantDomainEntityTest {

    private LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2021, 10, 10, 10, 10, 10, 10);

    private UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");


    @Test
    void shouldCreateRestaurantDomainEntity() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        RestaurantDomainEntity restaurantDomainEntity = createRestaurantDomainEntity(
                name,
                location,
                cuisineType,
                hoursOfOperation,
                capacity
        );

        // Assert
        Assertions
                .assertThat(restaurantDomainEntity)
                .hasFieldOrPropertyWithValue("name", name)
                .hasFieldOrPropertyWithValue("location", location)
                .hasFieldOrPropertyWithValue("cuisineType", cuisineType)
                .hasFieldOrPropertyWithValue("hoursOfOperation", hoursOfOperation)
                .hasFieldOrPropertyWithValue("tables", capacity);
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithNullName() {
        // Arrange
        String name = null;
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Name cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithEmptyName() {
        // Arrange
        String name = "";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Name cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithNullLocation() {
        // Arrange
        String name = "name";
        String location = null;
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Location cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithEmptyLocation() {
        // Arrange
        String name = "name";
        String location = "";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Location cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithNullCuisineType() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = null;
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Cuisine type cannot be null or empty");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithEmptyCuisineType() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "";
        Double hoursOfOperation = 1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions.
                assertThat(exception.getMessage())
                .isEqualTo("Cuisine type cannot be null or empty");
    }

    @Test
    void sholdThrowExceptionWhenCreateRestaurantDomainEntityWithZeroHoursOfOperation() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = -0.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Hours of operation cannot be null or less than or equal to 0");
    }

    @Test
    void sholdThrowExceptionWhenCreateRestaurantDomainEntityWithInvalidHoursOfOperation() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = -1.0;
        Integer capacity = 1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Hours of operation cannot be null or less than or equal to 0");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithNullCapacity() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = null;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions
                .assertThat(exception.getMessage())
                .isEqualTo("Capacity cannot be null or less than or equal to 0");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithZeroCapacity() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = 0;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions.assertThat(exception.getMessage()).isEqualTo("Capacity cannot be null or less than or equal to 0");
    }

    @Test
    void shouldThrowExceptionWhenCreateRestaurantDomainEntityWithNegativeCapacity() {
        // Arrange
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        Double hoursOfOperation = 1.0;
        Integer capacity = -1;

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createRestaurantDomainEntity(
                    name,
                    location,
                    cuisineType,
                    hoursOfOperation,
                    capacity
            );
        });

        // Assert
        Assertions.assertThat(exception.getMessage()).isEqualTo("Capacity cannot be null or less than or equal to 0");

    }

    private RestaurantDomainEntity createRestaurantDomainEntity(
            String name,
            String location,
            String cuisineType,
            Double hoursOfOperation,
            Integer capacity
    ) {
        return new RestaurantDomainEntity(uuid, name, location, cuisineType, hoursOfOperation, capacity, LOCAL_DATE_TIME);
    }
}