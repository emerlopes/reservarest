package com.fiap.reservarest.application.entrypoint.rest.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {

    @JsonProperty("reservation_id")
    private Long reservationId;

    @JsonProperty("reservation_name")
    private String reservationName;

    @JsonProperty("reservation_time")
    private LocalDateTime reservationTime;

    @JsonProperty("amount_people")
    private Integer amountPeople;

    @JsonProperty("restaurant")
    private RestaurantResponseDTO restaurantResponseDTO;

    public BookingResponseDTO(
            final Long reservationId,
            final String reservationName,
            final LocalDateTime reservationTime,
            final Integer amountPeople,
            final RestaurantResponseDTO restaurantResponseDTO
    ) {
        this.reservationId = reservationId;
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.amountPeople = amountPeople;
        this.restaurantResponseDTO = restaurantResponseDTO;
    }
}
