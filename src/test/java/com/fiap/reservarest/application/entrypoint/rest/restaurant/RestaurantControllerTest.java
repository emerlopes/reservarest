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
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        String name = "name";
        String location = "location";
        String cuisineType = "cuisineType";
        double rating = 10.0;
        int capacity = 100;

        RestaurantRequestDTO restaurant = createRestaurantRequestDTO(
                name,
                location,
                cuisineType,
                rating,
                capacity
        );

        RestaurantDomainEntity restaurantDomainEntity = new RestaurantDomainEntity(
                UUID.randomUUID(),
                name,
                location,
                cuisineType,
                rating,
                capacity,
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
        List<RestaurantDomainEntity> restaurantSearchDomainEntityResult = Collections.singletonList(new RestaurantDomainEntity());

        Mockito.when(restaurantSearchUseCase.execute(Mockito.any(RestaurantSearchDomainEntity.class))).thenReturn(restaurantSearchDomainEntityResult);

        // Act
        final var result = restaurantController.searchRestaurant(null);

        // Assert
        assertThat(result).isNotNull();
    }

    @Test
    void shouldSearchRestaurantWhenReturnIsNotEmpty() {
        // Arrange
        List<RestaurantDomainEntity> restaurantSearchDomainEntityResult = new ArrayList<>();
        restaurantSearchDomainEntityResult.add(new RestaurantDomainEntity());

        Mockito.when(restaurantSearchUseCase.execute(Mockito.any(RestaurantSearchDomainEntity.class))).thenReturn(restaurantSearchDomainEntityResult);

        // Act
        final var result = restaurantController.searchRestaurant(null);

        // Assert
        assertThat(result).isNotNull();
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