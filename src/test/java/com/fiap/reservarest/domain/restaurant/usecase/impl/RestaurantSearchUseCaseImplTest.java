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
        final var restaurantSearchDomainEntity = new RestaurantSearchDomainEntity("restaurante");
        final var result = restaurantSearchUseCase.execute(restaurantSearchDomainEntity);

        Assertions.assertThat(result).isEmpty();

    }

    @Test
    void shouldReturnListRestaurantsWhenNullKeyWord() {
        final var restaurantSearchDomainEntity = new RestaurantSearchDomainEntity(null);
        final var result = restaurantSearchUseCase.execute(restaurantSearchDomainEntity);

        Assertions.assertThat(result).isEmpty();

    }

}