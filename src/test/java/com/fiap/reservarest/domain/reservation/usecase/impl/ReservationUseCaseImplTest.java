package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ReservationUseCaseImplTest {

    @InjectMocks
    private ReservationUseCaseImpl bookingUseCase;

    @Mock
    private ReservationService reservationService;

    @Mock
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldExecuteSuccessfully() {
        // Arrange
        UUID restaurantId = UUID.randomUUID();

        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                "Teste",
                "email",
                "phone",
                LocalDateTime.now(),
                2,
                restaurantId,
                null
        );

        RestaurantDomainEntity restaurantDomainEntity = new RestaurantDomainEntity();

        when(restaurantService.findByExternalId(restaurantId)).thenReturn(restaurantDomainEntity);
        when(reservationService.reservation(any(ReservationDomainEntity.class))).thenReturn(reservationDomainEntity);

        // Act
        ReservationDomainEntity result = bookingUseCase.execute(reservationDomainEntity);

        // Assert
        verify(restaurantService, times(1)).findByExternalId(restaurantId);
        verify(reservationService, times(1)).reservation(any(ReservationDomainEntity.class));
        assertEquals(reservationDomainEntity, result);
    }


}