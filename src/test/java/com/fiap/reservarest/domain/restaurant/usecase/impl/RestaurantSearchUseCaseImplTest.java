package com.fiap.reservarest.domain.restaurant.usecase.impl;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantSearchDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class RestaurantSearchUseCaseImplTest {

    @InjectMocks
    private RestaurantSearchUseCaseImpl restaurantSearchUseCase;

    @Mock
    private RestaurantService restaurantService;

    private List<RestaurantDomainEntity> returnDomainEntity;

    @BeforeEach
    void setUp() {
        returnDomainEntity = List.of(new RestaurantDomainEntity());
    }

    @Test
    void shouldReturnListRestaurants() {
        // Arrange
        RestaurantSearchDomainEntity restaurantSearchDomainEntity = new RestaurantSearchDomainEntity("restaurante");

        // Act
        List<RestaurantDomainEntity> result = restaurantSearchUseCase.execute(restaurantSearchDomainEntity);

        // Assert
        assertThat(result).isEmpty();
    }


    @Test
    void shouldReturnListRestaurantsWhenNullKeyWord() {
        // Arrange
        RestaurantSearchDomainEntity restaurantSearchDomainEntity = new RestaurantSearchDomainEntity(null);

        // Act
        List<RestaurantDomainEntity> result = restaurantSearchUseCase.execute(restaurantSearchDomainEntity);

        // Assert
        assertThat(result).isEmpty();
    }


}