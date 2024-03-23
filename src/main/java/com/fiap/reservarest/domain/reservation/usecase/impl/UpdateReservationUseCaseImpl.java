package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByIdDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.UpdateReservationByIdDomainEntity;
import com.fiap.reservarest.domain.reservation.exception.ReservationDomainCustomException;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.reservation.usecase.UpdateReservationUseCase;

public class UpdateReservationUseCaseImpl implements UpdateReservationUseCase {

    private final ReservationService reservationService;

    public UpdateReservationUseCaseImpl(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public ReservationDomainEntity execute(final UpdateReservationByIdDomainEntity updateReservationByIdDomainEntity) {
        final var newReservationStatus = updateReservationByIdDomainEntity.getStatus();
        final var reservationSearchByIdDomainEntity = new ReservationSearchByIdDomainEntity(updateReservationByIdDomainEntity.getReservationId());
        final var reservation = reservationService.findReservationById(reservationSearchByIdDomainEntity);
        final var currentReservationStatus = reservation.getStatus().toString();

        if (currentReservationStatus.equals(ReservationStatusEnum.CANCELED.toString())
                || currentReservationStatus.equals(ReservationStatusEnum.RELEASED.toString())
        ) {
            throw new ReservationDomainCustomException("Reservation cannot be updated because it is already canceled or released");
        }

        reservation.setStatus(ReservationStatusEnum.fromString(updateReservationByIdDomainEntity.getStatus()));

        if (newReservationStatus.equals(ReservationStatusEnum.CANCELED.toString())
                || newReservationStatus.equals(ReservationStatusEnum.RELEASED.toString())
        ) {
            reservationService.releaseTables(reservation);
        }

        return reservationService.updateReservation(reservation);
    }
}
