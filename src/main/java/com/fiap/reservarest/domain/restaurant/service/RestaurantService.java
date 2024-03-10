package com.fiap.reservarest.domain.restaurant.service;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.util.List;

public interface RestaurantService {
    RestaurantDomainEntity createRestaurant(RestaurantDomainEntity restaurantDomainEntity);
    List<RestaurantDomainEntity> findRestaurantBySearch(String name);
    List<RestaurantDomainEntity> findRestaurants();
}
