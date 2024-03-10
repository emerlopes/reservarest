package com.fiap.reservarest.domain.booking.entity;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.time.LocalDateTime;

public class BookingDomainEntity {

    private Long reservationId;
    private String reservationName;
    private LocalDateTime reservationTime;
    private Integer amountPeople;
    private String restaurantName;
    private RestaurantDomainEntity restaurantDomainEntity;

    public BookingDomainEntity(
            final String reservationName,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final String restaurantName
    ) {
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
    }

    public BookingDomainEntity(
            final Long reservationId,
            final String reservationName,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        this.reservationId = reservationId;
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Integer getAmountPeople() {
        return amountPeople;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public RestaurantDomainEntity getRestaurantDomainEntity() {
        return restaurantDomainEntity;
    }
}
