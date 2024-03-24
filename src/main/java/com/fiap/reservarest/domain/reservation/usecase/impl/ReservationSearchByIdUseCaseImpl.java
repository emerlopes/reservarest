package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByIdDomainEntity;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByIdUseCase;

public class ReservationSearchByIdUseCaseImpl implements ReservationSearchByIdUseCase {

    private final ReservationService reservationService;

    public ReservationSearchByIdUseCaseImpl(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public ReservationDomainEntity execute(final ReservationSearchByIdDomainEntity reservationSearchByIdDomainEntity) {
        return reservationService.findReservationById(reservationSearchByIdDomainEntity);
    }
}
