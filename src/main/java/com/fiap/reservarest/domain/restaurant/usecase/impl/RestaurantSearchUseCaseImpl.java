package com.fiap.reservarest.domain.restaurant.usecase.impl;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantSearchDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantSearchUseCase;

import java.util.List;
import java.util.Locale;

public class RestaurantSearchUseCaseImpl implements RestaurantSearchUseCase {

    private final RestaurantService restaurantService;

    public RestaurantSearchUseCaseImpl(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public List<RestaurantDomainEntity> execute(
            RestaurantSearchDomainEntity restaurantSearchDomainEntity
    ) {
        final var keyword = restaurantSearchDomainEntity.getKeyWord();

        if (keyword != null)
            return restaurantService.findRestaurantBySearch(keyword.toLowerCase(Locale.ROOT));

        return restaurantService.findRestaurants();
    }
}
