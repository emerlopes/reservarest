package com.fiap.reservarest.domain.restaurant.service;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {
    RestaurantDomainEntity saveRestaurant(RestaurantDomainEntity restaurantDomainEntity);

    List<RestaurantDomainEntity> findRestaurantByKeyWord(String name);

    List<RestaurantDomainEntity> findRestaurants();

    RestaurantDomainEntity findByExternalId(UUID externalId);
}
