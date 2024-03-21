package com.fiap.reservarest.domain.reservation.service;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByIdDomainEntity;

import java.util.List;

public interface ReservationService {
    ReservationDomainEntity reservation(ReservationDomainEntity reservationDomainEntity);

    ReservationDomainEntity findReservationById(ReservationSearchByIdDomainEntity reservationSearchByIdDomainEntity);

    List<ReservationDomainEntity> findReservationByRestaurantId(Long restaurantId);

    void updateQuantityTableByPeople(ReservationDomainEntity reservationDomainEntity);

}
