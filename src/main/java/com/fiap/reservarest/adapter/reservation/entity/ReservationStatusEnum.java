package com.fiap.reservarest.adapter.reservation.entity;

public enum ReservationStatusEnum {

    PENDING,
    CONFIRMED,
    CANCELED;

    private String status;

    ReservationStatusEnum() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
