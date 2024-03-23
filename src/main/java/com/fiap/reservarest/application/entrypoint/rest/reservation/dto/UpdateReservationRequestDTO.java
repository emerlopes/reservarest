package com.fiap.reservarest.application.entrypoint.rest.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UpdateReservationRequestDTO {

    @JsonProperty("reservation_id")
    private Long reservationId;

    @JsonProperty("status")
    private String status;

}
