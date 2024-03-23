package com.fiap.reservarest.adapter.reservation.entity;

import com.fiap.reservarest.domain.reservation.exception.ReservationDomainCustomException;

public enum ReservationStatusEnum {

    PENDING,
    CONFIRMED,
    RELEASED,
    CANCELED;

    private String status;

    ReservationStatusEnum() {
        this.status = this.name();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ReservationStatusEnum fromString(String status) {

        for (ReservationStatusEnum reservationStatusEnum : ReservationStatusEnum.values()) {
            if (reservationStatusEnum.getStatus().equalsIgnoreCase(status)) {
                return reservationStatusEnum;
            }
        }
        throw new ReservationDomainCustomException("Invalid reservation status, please provide a valid status: PENDING, CONFIRMED, RELEASED or CANCELED.");
    }
}
