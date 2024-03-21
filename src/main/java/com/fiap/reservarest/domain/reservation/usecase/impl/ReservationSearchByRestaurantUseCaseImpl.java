package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByRestaurantDomainEntity;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByRestaurantUseCase;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;

import java.util.List;

public class ReservationSearchByRestaurantUseCaseImpl implements ReservationSearchByRestaurantUseCase {

    private final ReservationService reservationService;
    private final RestaurantService restaurantService;

    public ReservationSearchByRestaurantUseCaseImpl(
            final ReservationService reservationService,
            final RestaurantService restaurantService
    ) {
        this.reservationService = reservationService;
        this.restaurantService = restaurantService;
    }


    @Override
    public List<ReservationDomainEntity> execute(ReservationSearchByRestaurantDomainEntity reservationSearchByRestaurantDomainEntity) {
        final var restaurantExternalId = reservationSearchByRestaurantDomainEntity.getRestaurantExternalId();
        final var restaurantDomainEntity = restaurantService.findByExternalId(restaurantExternalId);

        return reservationService.findReservationByRestaurantId(restaurantDomainEntity.getId());
    }
}
