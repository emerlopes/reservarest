package com.fiap.reservarest.application.entrypoint.rest.reservation;

import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.ReservationRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.UpdateReservationRequestDTO;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByRestaurantDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.UpdateReservationByIdDomainEntity;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByRestaurantUseCase;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
import com.fiap.reservarest.domain.reservation.usecase.UpdateReservationUseCase;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ResevationControllerTest {

    @InjectMocks
    private ResevationController resevationController;

    @Mock
    private ReservationUseCase reservationUseCase;

    @Mock
    private UpdateReservationUseCase updateReservationUseCase;

    @Mock
    private ReservationSearchByRestaurantUseCase reservationSearchByRestaurantUseCase;


    @Test
    void bookingShouldReturnCreatedStatusWhenBookingIsSuccessful() {
        // Arrange
        LocalDateTime reservationTime = LocalDateTime.now();
        String reservationName = "reservationName";
        int amountPeople = 2;
        UUID restaurantId = UUID.randomUUID();

        ReservationRequestDTO reservationRequestDTO = createBookingRequestDTO(reservationName, reservationTime, amountPeople, restaurantId);

        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                1L,
                reservationName,
                null,
                null,
                reservationTime,
                amountPeople,
                new RestaurantDomainEntity(),
                ReservationStatusEnum.PENDING
        );

        Mockito.when(reservationUseCase.execute(Mockito.any(ReservationDomainEntity.class))).thenReturn(reservationDomainEntity);

        // Act
        ResponseEntity<?> response = resevationController.reservationTable(reservationRequestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void shouldUpdateReservationSuccessfully() {
        // Arrange
        UpdateReservationRequestDTO updateReservationRequestDTO = new UpdateReservationRequestDTO();
        LocalDateTime reservationTime = LocalDateTime.now();
        String reservationName = "reservationName";

        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                1L,
                reservationName,
                null,
                null,
                reservationTime,
                null,
                new RestaurantDomainEntity(),
                ReservationStatusEnum.PENDING
        );

        Mockito.when(updateReservationUseCase.execute(Mockito.any(UpdateReservationByIdDomainEntity.class))).thenReturn(reservationDomainEntity);

        // Act
        ResponseEntity<?> response = resevationController.updateReservation(updateReservationRequestDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldGetReservationsByRestaurantSuccessfully() {
        // Arrange
        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                1L,
                "reservationName",
                null,
                null,
                LocalDateTime.now(),
                null,
                new RestaurantDomainEntity(),
                ReservationStatusEnum.PENDING
        );

        Mockito.when(reservationSearchByRestaurantUseCase.execute(Mockito.any(ReservationSearchByRestaurantDomainEntity.class))).thenReturn(List.of(reservationDomainEntity));

        // Act
        ResponseEntity<?> response = resevationController.getReservationsByRestaurant(UUID.randomUUID().toString());

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldGetReservationsByRestaurantSuccessfullyWithNoContent() {
        // Arrange
        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                1L,
                "reservationName",
                null,
                null,
                LocalDateTime.now(),
                null,
                new RestaurantDomainEntity(),
                ReservationStatusEnum.PENDING
        );

        Mockito.when(reservationSearchByRestaurantUseCase.execute(Mockito.any(ReservationSearchByRestaurantDomainEntity.class))).thenReturn(new ArrayList<>());

        // Act
        ResponseEntity<?> response = resevationController.getReservationsByRestaurant(UUID.randomUUID().toString());

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    private ReservationRequestDTO createBookingRequestDTO(String reservationName, LocalDateTime reservationTime, int amountPeople, UUID restaurantId) {
        ReservationRequestDTO reservationRequestDTO = new ReservationRequestDTO();
        reservationRequestDTO.setReservationName(reservationName);
        reservationRequestDTO.setReservationTime(reservationTime);
        reservationRequestDTO.setAmountPeople(amountPeople);
        reservationRequestDTO.setRestaurantId(restaurantId);
        reservationRequestDTO.setStatus(ReservationStatusEnum.PENDING.getStatus());
        return reservationRequestDTO;
    }

}