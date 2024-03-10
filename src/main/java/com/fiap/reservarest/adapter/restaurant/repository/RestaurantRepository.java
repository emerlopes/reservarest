package com.fiap.reservarest.adapter.restaurant.repository;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    @Query("SELECT r FROM RestaurantEntity r " +
            "WHERE r.name LIKE %:keyword% " +
            "OR r.location LIKE %:keyword% " +
            "OR r.cuisineType LIKE %:keyword%"
    )
    List<RestaurantEntity> findRestaurantsByKeyword(String keyword);
}
