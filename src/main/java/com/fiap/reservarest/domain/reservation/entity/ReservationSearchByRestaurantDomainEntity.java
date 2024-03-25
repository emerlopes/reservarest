package com.fiap.reservarest.domain.reservation.entity;

import java.util.UUID;

public class ReservationSearchByRestaurantDomainEntity {

    private UUID restaurantExternalId;

    public ReservationSearchByRestaurantDomainEntity(
            final UUID restaurantExternalId
    ) {
        this.restaurantExternalId = restaurantExternalId;
    }

    public UUID getRestaurantExternalId() {
        return restaurantExternalId;
    }
}
