package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByRestaurantDomainEntity;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ReservationSearchByRestaurantUseCaseImplTest {

    @Mock
    private ReservationService reservationService;

    @Mock
    private RestaurantService restaurantService;

    @Mock
    private ReservationSearchByRestaurantUseCaseImpl reservationSearchByRestaurantUseCase;

    @Test
    void executeShouldReturnReservationsWhenRestaurantExists() {
        ReservationSearchByRestaurantDomainEntity reservationSearchByRestaurantDomainEntity = new ReservationSearchByRestaurantDomainEntity(UUID.randomUUID());
        List<ReservationDomainEntity> expectedReservations = new ArrayList<>();

        List<ReservationDomainEntity> actualReservations = reservationSearchByRestaurantUseCase.execute(reservationSearchByRestaurantDomainEntity);


        Assertions.assertThat(actualReservations).isEqualTo(expectedReservations);
    }

}