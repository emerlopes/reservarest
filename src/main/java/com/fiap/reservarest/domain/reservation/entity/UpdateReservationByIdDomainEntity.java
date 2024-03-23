package com.fiap.reservarest.domain.reservation.entity;

public class UpdateReservationByIdDomainEntity {

    private final Long reservationId;
    private final String status;

    public UpdateReservationByIdDomainEntity(final Long reservationId, final String status) {
        this.reservationId = reservationId;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getStatus() {
        return status;
    }
}
