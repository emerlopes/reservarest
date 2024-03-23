package com.fiap.reservarest.application.entrypoint.rest.reservation.dto;

import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ReservationResponseDTOTest {

    private ReservationResponseDTO reservationResponseDTO;

    @BeforeEach
    void setUp() {
        reservationResponseDTO = new ReservationResponseDTO(
                1L,
                "John's Reservation",
                "email",
                "phone",
                LocalDateTime.now(),
                4,
                new RestaurantResponseDTO(
                        UUID.randomUUID(),
                        "Restaurant",
                        "Address",
                        "Japonesa",
                        8.0,
                        8,
                        LocalDateTime.now()
                ),
                ReservationStatusEnum.CONFIRMED
        );
    }

    @Test
    void shouldReturnCorrectReservationIdWhenSet() {
        Long expectedReservationId = 1L;
        reservationResponseDTO.setReservationId(expectedReservationId);

        assertEquals(expectedReservationId, reservationResponseDTO.getReservationId());
    }

    @Test
    void shouldReturnCorrectReservationNameWhenSet() {
        String expectedReservationName = "John's Reservation";
        reservationResponseDTO.setReservationName(expectedReservationName);

        assertEquals(expectedReservationName, reservationResponseDTO.getReservationName());
    }

    @Test
    void shouldReturnCorrectReservationTimeWhenSet() {
        LocalDateTime expectedReservationTime = LocalDateTime.now();
        reservationResponseDTO.setReservationTime(expectedReservationTime);

        assertEquals(expectedReservationTime, reservationResponseDTO.getReservationTime());
    }

    @Test
    void shouldReturnCorrectAmountPeopleWhenSet() {
        Integer expectedAmountPeople = 4;
        reservationResponseDTO.setAmountPeople(expectedAmountPeople);

        assertEquals(expectedAmountPeople, reservationResponseDTO.getAmountPeople());
    }

    @Test
    void shouldReturnCorrectRestaurantResponseDTOWhenSet() {
        final var expectedRestaurantResponseDTO = new RestaurantResponseDTO(
                UUID.randomUUID(),
                "Restaurant",
                "Address",
                "Japonesa",
                8.0,
                8,
                LocalDateTime.now()
        );
        reservationResponseDTO.setRestaurantResponseDTO(expectedRestaurantResponseDTO);

        assertEquals(expectedRestaurantResponseDTO, reservationResponseDTO.getRestaurantResponseDTO());
    }
}