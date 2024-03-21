package com.fiap.reservarest.domain.booking.entity;

import com.fiap.reservarest.adapter.booking.entity.BookingStatusEnum;
import com.fiap.reservarest.domain.booking.exception.BookingDomainCustomException;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingDomainEntity {

    private Long bookingId;
    private String reservationName;
    private String reservationEmail;
    private String reservationPhone;
    private LocalDateTime reservationTime;
    private Integer amountPeople;
    private UUID restaurantExternalId;
    private RestaurantDomainEntity restaurantDomainEntity;
    private BookingStatusEnum status;

    public BookingDomainEntity(
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final UUID restaurantExternalId,
            final BookingStatusEnum status
    ) {
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantExternalId = restaurantExternalId;
        this.status = status;
    }

    public BookingDomainEntity(
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity,
            final BookingStatusEnum status
    ) {
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
        this.status = status;
    }

    public BookingDomainEntity(
            final Long bookingId,
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity,
            final BookingStatusEnum status
    ) {
        this.bookingId = bookingId;
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
        this.status = status;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public String getReservationPhone() {
        return reservationPhone;
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

    public BookingStatusEnum getStatus() {
        return status;
    }

    private void validateReservationTable() {
        if (this.amountPeople > 4) {
            throw new BookingDomainCustomException("Restaurant has no tables available for the amount of people");
        }
    }

}
