package com.fiap.reservarest.application.entrypoint.rest.reservation;

import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.ReservationRequestDTO;
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
class ResevationControllerTest {

    @InjectMocks
    private ResevationController resevationController;

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

        ReservationRequestDTO reservationRequestDTO = createBookingRequestDTO(
                reservationName,
                reservationTime,
                amountPeople,
                restaurantId
        );

        Mockito.when(reservationUseCase.execute(Mockito.any(ReservationDomainEntity.class))).thenReturn(reservationDomainEntity);

        // Act
        ResponseEntity<?> response = resevationController.reservationTable(reservationRequestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private ReservationRequestDTO createBookingRequestDTO(String reservationName, LocalDateTime reservationTime, int amountPeople, UUID restaurantId) {
        ReservationRequestDTO reservationRequestDTO = new ReservationRequestDTO();
        reservationRequestDTO.setReservationName(reservationName);
        reservationRequestDTO.setReservationTime(reservationTime);
        reservationRequestDTO.setAmountPeople(amountPeople);
        reservationRequestDTO.setRestaurantId(restaurantId);
        return reservationRequestDTO;
    }

}