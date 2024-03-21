package com.fiap.reservarest.domain.reservation.service;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;

public interface ReservationService {
    ReservationDomainEntity reservation(ReservationDomainEntity reservationDomainEntity);

    void updateQuantityTableByPeople(ReservationDomainEntity reservationDomainEntity);

}
