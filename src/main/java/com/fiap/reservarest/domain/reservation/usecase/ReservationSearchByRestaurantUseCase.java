package com.fiap.reservarest.domain.reservation.usecase;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByRestaurantDomainEntity;
import com.fiap.reservarest.domain.shared.ExecuteUseCase;

import java.util.List;

public interface ReservationSearchByRestaurantUseCase extends ExecuteUseCase<List<ReservationDomainEntity>, ReservationSearchByRestaurantDomainEntity> {
}
