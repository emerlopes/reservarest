package com.fiap.reservarest.domain.reservation.usecase;

import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.UpdateReservationByIdDomainEntity;
import com.fiap.reservarest.domain.shared.ExecuteUseCase;

public interface UpdateReservationUseCase extends ExecuteUseCase<ReservationDomainEntity, UpdateReservationByIdDomainEntity> {
}
