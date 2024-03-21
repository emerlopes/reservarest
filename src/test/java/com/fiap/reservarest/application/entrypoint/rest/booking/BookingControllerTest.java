package com.fiap.reservarest.application.entrypoint.rest.booking;

import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
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
    private ReservationUseCase reservationUseCase;


    @Test
    void bookingShouldReturnCreatedStatusWhenBookingIsSuccessful() {
        // Arrange
        LocalDateTime reservationTime = LocalDateTime.now();
        UUID restaurantId = UUID.randomUUID();
        String reservationName = "reservationName";
        int amountPeople = 1;

        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                1L,
                reservationName,
                null,
                null,
                reservationTime,
                null,
                new RestaurantDomainEntity(),
                null
        );

        BookingRequestDTO bookingRequestDTO = createBookingRequestDTO(
                reservationName,
                reservationTime,
                amountPeople,
                restaurantId
        );

        Mockito.when(reservationUseCase.execute(Mockito.any(ReservationDomainEntity.class))).thenReturn(reservationDomainEntity);

        // Act
        ResponseEntity<?> response = bookingController.booking(bookingRequestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private BookingRequestDTO createBookingRequestDTO(String reservationName, LocalDateTime reservationTime, int amountPeople, UUID restaurantId) {
        BookingRequestDTO bookingRequestDTO = new BookingRequestDTO();
        bookingRequestDTO.setReservationName(reservationName);
        bookingRequestDTO.setReservationTime(reservationTime);
        bookingRequestDTO.setAmountPeople(amountPeople);
        bookingRequestDTO.setRestaurantId(restaurantId);
        return bookingRequestDTO;
    }

}