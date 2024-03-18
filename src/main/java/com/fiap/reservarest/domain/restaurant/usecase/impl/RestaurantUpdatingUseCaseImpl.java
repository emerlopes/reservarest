package com.fiap.reservarest.domain.restaurant.usecase.impl;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantUpdatingUseCase;

public class RestaurantUpdatingUseCaseImpl implements RestaurantUpdatingUseCase {

    private final RestaurantService restaurantService;

    public RestaurantUpdatingUseCaseImpl(
            final RestaurantService restaurantService
    ) {
        this.restaurantService = restaurantService;
    }

    @Override
    public RestaurantDomainEntity execute(RestaurantDomainEntity restaurantDomainEntity) {
        return null;
    }
}
