package com.fiap.reservarest.domain.restaurant.usecase.impl;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;

public class RestaurantCreationUseCaseImpl implements RestaurantCreationUseCase {

    private final RestaurantService restaurantService;

    public RestaurantCreationUseCaseImpl(
            final RestaurantService restaurantService
    ) {
        this.restaurantService = restaurantService;
    }

    @Override
    public RestaurantDomainEntity execute(
            final RestaurantDomainEntity restaurantDomainEntity
    ) {

        return restaurantService.createRestaurant(restaurantDomainEntity);
    }
}
