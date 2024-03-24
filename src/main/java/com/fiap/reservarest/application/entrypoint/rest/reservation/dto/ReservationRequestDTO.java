package com.fiap.reservarest.application.entrypoint.rest.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {

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

    @JsonProperty("restaurant_id")
    private UUID restaurantId;

    @JsonProperty("status")
    private String status;

}
