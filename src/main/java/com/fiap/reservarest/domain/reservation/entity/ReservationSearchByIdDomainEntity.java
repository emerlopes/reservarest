package com.fiap.reservarest.domain.reservation.entity;

public class ReservationSearchByIdDomainEntity {

    private Long reservationId;

    public ReservationSearchByIdDomainEntity(final Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getReservationId() {
        return reservationId;
    }
}
