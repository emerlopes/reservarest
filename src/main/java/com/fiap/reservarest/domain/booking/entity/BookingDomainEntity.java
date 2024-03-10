package com.fiap.reservarest.domain.booking.entity;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingDomainEntity {

    private Long bookingId;
    private String reservationName;
    private LocalDateTime reservationTime;
    private Integer amountPeople;
    private UUID restaurantExternalId;
    private RestaurantDomainEntity restaurantDomainEntity;

    public BookingDomainEntity(
            final String reservationName,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final UUID restaurantExternalId
    ) {
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantExternalId = restaurantExternalId;
    }

    public BookingDomainEntity(
            final String reservationName,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
    }

    public BookingDomainEntity(
            final Long bookingId,
            final String reservationName,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        this.bookingId = bookingId;
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
    }

    public Long getBookingId() {
        return bookingId;
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

    public UUID getRestaurantExternalId() {
        return restaurantExternalId;
    }

    public RestaurantDomainEntity getRestaurantDomainEntity() {
        return restaurantDomainEntity;
    }

}
