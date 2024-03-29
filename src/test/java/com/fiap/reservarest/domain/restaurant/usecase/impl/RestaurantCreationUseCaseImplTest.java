package com.fiap.reservarest.domain.restaurant.usecase.impl;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantCreationUseCaseImplTest {

    @InjectMocks
    private RestaurantCreationUseCaseImpl restaurantCreationUseCase;

    @Mock
    private RestaurantService restaurantService;

    private LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2021, 10, 10, 10, 10, 10, 10);

    private UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

    @Test
    void shouldCreateRestaurant() {
        // Arrange
        final var restaurantDomainEntity = this.createRestaurantDomainEntity(
                "name",
                "location",
                "cuisineType",
                1.0,
                1
        );

        Mockito.when(restaurantService.createRestaurant(restaurantDomainEntity)).thenReturn(restaurantDomainEntity);

        // Act
        final var result = restaurantCreationUseCase.execute(restaurantDomainEntity);

        // Assert
        Assertions
                .assertThat(result)
                .isEqualTo(restaurantDomainEntity)
                .describedAs("The result should be the same as the restaurantDomainEntity");
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