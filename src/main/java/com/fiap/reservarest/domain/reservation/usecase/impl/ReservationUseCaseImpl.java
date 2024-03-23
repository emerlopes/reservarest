package com.fiap.reservarest.domain.reservation.usecase.impl;

import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.adapter.reservation.mapper.ReservationMapper;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.exception.ReservationDomainCustomException;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.springframework.transaction.annotation.Transactional;

public class ReservationUseCaseImpl implements ReservationUseCase {

    private final ReservationService reservationService;
    private final RestaurantService restaurantService;

    public ReservationUseCaseImpl(
            final ReservationService reservationService,
            final RestaurantService restaurantService
    ) {
        this.reservationService = reservationService;
        this.restaurantService = restaurantService;
    }

    @Override
    @Transactional
    public ReservationDomainEntity execute(ReservationDomainEntity reservationDomainEntity) {

        final var reservationStatus = reservationDomainEntity.getStatus();

        if (reservationStatus != null && reservationStatus.equals(ReservationStatusEnum.CANCELED)) {
            throw new ReservationDomainCustomException("Status cannot be canceled for reservation creation");
        }

        final var restaurantExternalId = reservationDomainEntity.getRestaurantExternalId();
        final var restaurantDomainEntity = restaurantService.findByExternalId(restaurantExternalId);
        final var domainEntity = ReservationMapper.toDomainEntity(reservationDomainEntity, restaurantDomainEntity);

        reservationService.updateQuantityTableByPeople(domainEntity);

        return reservationService.reservation(domainEntity);
    }
}
