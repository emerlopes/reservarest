package com.fiap.reservarest.adapter.reservation.repository;

import com.fiap.reservarest.adapter.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByRestaurantEntityRestaurantId(Long restaurantId);
}
