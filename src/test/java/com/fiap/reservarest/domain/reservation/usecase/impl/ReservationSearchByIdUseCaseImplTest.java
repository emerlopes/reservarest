package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.adapter.reservation.entity.ReservationEntity;
import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByIdDomainEntity;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.reservation.usecase.impl.ReservationSearchByIdUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ReservationSearchByIdUseCaseImplTest {

    @Mock
    private ReservationService reservationService;

    private ReservationSearchByIdUseCaseImpl reservationSearchByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reservationSearchByIdUseCase = new ReservationSearchByIdUseCaseImpl(reservationService);
    }

    @Test
    void executeShouldReturnNullWhenIdDoesNotExist() {
        ReservationSearchByIdDomainEntity reservationSearchByIdDomainEntity = new ReservationSearchByIdDomainEntity(1L);
        when(reservationService.findReservationById(reservationSearchByIdDomainEntity)).thenReturn(null);

        ReservationDomainEntity actualReservation = reservationSearchByIdUseCase.execute(reservationSearchByIdDomainEntity);

        assertEquals(null, actualReservation);
    }
}