package com.fiap.reservarest.application.entrypoint.rest.restaurant;

import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private RestaurantCreationUseCase restaurantCreationUseCase;

    @Test
    void testCreateRestaurantSuccess() {
        // Arrange
        final var restaurant = this.createRestaurantRequestDTO(
                "name",
                "location",
                "cuisineType",
                10.0,
                100);

        final var restaurantDomainEntity = new RestaurantDomainEntity(
                UUID.randomUUID(),
                "name",
                "location",
                "cuisineType",
                10.0,
                100,
                LocalDateTime.now()
        );

        Mockito.when(restaurantCreationUseCase.execute(Mockito.any())).thenReturn(restaurantDomainEntity);

        // Act
        restaurantController.createRestaurant(restaurant);

        // Assert
        Mockito.verify(restaurantCreationUseCase, Mockito.times(1)).execute(Mockito.any());
    }

    private RestaurantRequestDTO createRestaurantRequestDTO(
            String name,
            String location,
            String cuisineType,
            Double hoursOfOperation,
            Integer capacity
    ) {
        return new RestaurantRequestDTO(
                name,
                location,
                cuisineType,
                hoursOfOperation,
                capacity
        );
    }

}