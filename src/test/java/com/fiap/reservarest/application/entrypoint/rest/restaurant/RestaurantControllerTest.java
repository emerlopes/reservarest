package com.fiap.reservarest.application.entrypoint.rest.restaurant;

import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantSearchDomainEntity;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantSearchUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private RestaurantCreationUseCase restaurantCreationUseCase;

    @Mock
    private RestaurantSearchUseCase restaurantSearchUseCase;

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

    @Test
    void shouldSearchRestaurantWhenReturnIsEmpty() {

        // Arrange
        final var restaurantSearchDomainEntityResult = List.of(new RestaurantDomainEntity());

        Mockito.when(restaurantSearchUseCase.execute(Mockito.any(RestaurantSearchDomainEntity.class))).thenReturn(restaurantSearchDomainEntityResult);

        // Act
        final var result = restaurantController.searchRestaurant(null);

        // Assert
        Assertions.assertThat(result).isNotNull();

    }

    @Test
    void shouldSearchRestaurantWhenReturnIsNotEmpty() {

        // Arrange
        final var restaurantSearchDomainEntityResult = new ArrayList<RestaurantDomainEntity>();

        Mockito.when(restaurantSearchUseCase.execute(Mockito.any(RestaurantSearchDomainEntity.class))).thenReturn(restaurantSearchDomainEntityResult);

        // Act
        final var result = restaurantController.searchRestaurant(null);

        // Assert
        Assertions.assertThat(result).isNotNull();

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