package com.fiap.reservarest.application.entrypoint.rest.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {

    @JsonProperty("reservation_id")
    private Long reservationId;

    @JsonProperty("reservation_name")
    private String reservationName;

    @JsonProperty("reservation_email")
    private String reservationEmail;

    @JsonProperty("reservation_phone")
    private String reservationPhone;

    @JsonProperty("reservation_time")
    private LocalDateTime reservationTime;

    @JsonProperty("amount_people")
    private Integer amountPeople;

    @JsonProperty("restaurant")
    private RestaurantResponseDTO restaurantResponseDTO;

    @JsonProperty("status")
    private ReservationStatusEnum status;

    public BookingResponseDTO(
            final Long reservationId,
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantResponseDTO restaurantResponseDTO,
            final ReservationStatusEnum status
    ) {
        this.reservationId = reservationId;
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantResponseDTO = restaurantResponseDTO;
        this.status = status;
    }
}
