package com.fiap.reservarest.domain.reservation.entity;

import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.domain.reservation.exception.ReservationDomainCustomException;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationDomainEntity {

    private Long reservationId;
    private final String reservationName;
    private final String reservationEmail;
    private final String reservationPhone;
    private final LocalDateTime reservationTime;
    private final Integer amountPeople;
    private UUID restaurantExternalId;
    private RestaurantDomainEntity restaurantDomainEntity;
    private ReservationStatusEnum status;

    public ReservationDomainEntity(
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final UUID restaurantExternalId,
            final ReservationStatusEnum status
    ) {
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantExternalId = restaurantExternalId;
        this.status = status;
    }

    public ReservationDomainEntity(
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity,
            final ReservationStatusEnum status
    ) {
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
        this.status = status;
    }

    public ReservationDomainEntity(
            final Long reservationId,
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantDomainEntity restaurantDomainEntity,
            final ReservationStatusEnum status
    ) {
        this.reservationId = reservationId;
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantDomainEntity = restaurantDomainEntity;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
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

    public ReservationStatusEnum getStatus() {
        return status;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setStatus(ReservationStatusEnum status) {
        this.status = status;
    }

    private void validateReservationTable() {
        if (this.amountPeople > 4) {
            throw new ReservationDomainCustomException("Restaurant has no tables available for the amount of people");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "reservation_id:" + reservationId +
                ", reservation_name:'" + reservationName + '\'' +
                ", reservation_email:'" + reservationEmail + '\'' +
                ", reservation_phone:'" + reservationPhone + '\'' +
                ", reservation_time:" + reservationTime +
                ", amount_people:" + amountPeople +
                ", restaurant_external_id:" + restaurantExternalId +
                ", restaurant_domain_entity:" + restaurantDomainEntity +
                ", status:" + status +
                '}';
    }
}
