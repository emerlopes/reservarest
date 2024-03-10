package com.fiap.reservarest.application.entrypoint.rest.booking.dto;

import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookingResponseDTOTest {

    private BookingResponseDTO bookingResponseDTO;

    @BeforeEach
    void setUp() {
        bookingResponseDTO = new BookingResponseDTO(
                1L,
                "John's Reservation",
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
                )
        );
    }

    @Test
    void shouldReturnCorrectReservationIdWhenSet() {
        Long expectedReservationId = 1L;
        bookingResponseDTO.setReservationId(expectedReservationId);

        assertEquals(expectedReservationId, bookingResponseDTO.getReservationId());
    }

    @Test
    void shouldReturnCorrectReservationNameWhenSet() {
        String expectedReservationName = "John's Reservation";
        bookingResponseDTO.setReservationName(expectedReservationName);

        assertEquals(expectedReservationName, bookingResponseDTO.getReservationName());
    }

    @Test
    void shouldReturnCorrectReservationTimeWhenSet() {
        LocalDateTime expectedReservationTime = LocalDateTime.now();
        bookingResponseDTO.setReservationTime(expectedReservationTime);

        assertEquals(expectedReservationTime, bookingResponseDTO.getReservationTime());
    }

    @Test
    void shouldReturnCorrectAmountPeopleWhenSet() {
        Integer expectedAmountPeople = 4;
        bookingResponseDTO.setAmountPeople(expectedAmountPeople);

        assertEquals(expectedAmountPeople, bookingResponseDTO.getAmountPeople());
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
        bookingResponseDTO.setRestaurantResponseDTO(expectedRestaurantResponseDTO);

        assertEquals(expectedRestaurantResponseDTO, bookingResponseDTO.getRestaurantResponseDTO());
    }
}