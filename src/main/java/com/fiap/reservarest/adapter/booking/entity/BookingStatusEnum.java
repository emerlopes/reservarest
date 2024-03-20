package com.fiap.reservarest.adapter.booking.entity;

public enum BookingStatusEnum {

    PENDING,
    CONFIRMED,
    CANCELED;

    private String status;

    BookingStatusEnum() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
