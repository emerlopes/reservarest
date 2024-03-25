package com.fiap.reservarest.domain.reservation.usecase;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByIdDomainEntity;
import com.fiap.reservarest.domain.shared.ExecuteUseCase;

public interface ReservationSearchByIdUseCase extends ExecuteUseCase<ReservationDomainEntity, ReservationSearchByIdDomainEntity> {
}
