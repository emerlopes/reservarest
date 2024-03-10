package com.fiap.reservarest.application.entrypoint.rest.booking;

import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.usecase.BookingUseCase;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingUseCase bookingUseCase;


    @Test
    void bookingShouldReturnCreatedStatusWhenBookingIsSuccessful() {

        final var bookingDomainEntity = new BookingDomainEntity(
                1L,
                "reservationTime",
                LocalDateTime.now(),
                null,
                new RestaurantDomainEntity()
        );

        BookingRequestDTO bookingRequestDTO = new BookingRequestDTO();
        bookingRequestDTO.setReservationName("reservationName");
        bookingRequestDTO.setReservationTime(LocalDateTime.now());
        bookingRequestDTO.setAmountPeople(1);
        bookingRequestDTO.setRestaurantId(UUID.randomUUID());

        Mockito.when(bookingUseCase.execute(Mockito.any(BookingDomainEntity.class))).thenReturn(bookingDomainEntity);

        ResponseEntity<?> response = bookingController.booking(bookingRequestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}