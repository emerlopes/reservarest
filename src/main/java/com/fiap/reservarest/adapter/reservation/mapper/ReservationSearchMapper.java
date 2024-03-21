package com.fiap.reservarest.adapter.reservation.mapper;

import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByRestaurantDomainEntity;

import java.util.UUID;

public class ReservationSearchMapper {

    public static ReservationSearchByRestaurantDomainEntity toDomainEntity(final UUID restaurantExternalId) {
        return new ReservationSearchByRestaurantDomainEntity(restaurantExternalId);
    }
}
