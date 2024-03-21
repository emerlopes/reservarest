package com.fiap.reservarest.domain.reservation.service;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;

import java.util.List;

public interface ReservationService {
    ReservationDomainEntity reservation(ReservationDomainEntity reservationDomainEntity);

    List<ReservationDomainEntity> findReservationByRestaurantId(Long restaurantId);

    void updateQuantityTableByPeople(ReservationDomainEntity reservationDomainEntity);

}
