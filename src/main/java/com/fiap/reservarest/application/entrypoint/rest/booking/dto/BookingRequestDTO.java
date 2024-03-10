package com.fiap.reservarest.application.entrypoint.rest.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookingRequestDTO {

    @JsonProperty("reservation_name")
    private String reservationName;

    @JsonProperty("reservation_time")
    private LocalDateTime reservationTime;

    @JsonProperty("amount_people")
    private Integer amountPeople;

    @JsonProperty("restaurant_id")
    private UUID restaurantId;

}
