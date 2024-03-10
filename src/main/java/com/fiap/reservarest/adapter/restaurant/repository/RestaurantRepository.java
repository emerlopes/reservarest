package com.fiap.reservarest.adapter.restaurant.repository;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
