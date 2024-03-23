package com.fiap.reservarest.adapter.reservation.mapper;

import com.fiap.reservarest.adapter.reservation.entity.ReservationEntity;
import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.ReservationRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.ReservationResponseDTO;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.util.List;

public class ReservationMapper {

    public static ReservationEntity toEntity(final ReservationDomainEntity reservationDomainEntity) {
        return new ReservationEntity(
                reservationDomainEntity.getReservationName(),
                reservationDomainEntity.getReservationEmail(),
                reservationDomainEntity.getReservationPhone(),
                reservationDomainEntity.getReservationTime(),
                RestaurantMapper.toEntity(reservationDomainEntity.getRestaurantDomainEntity()),
                reservationDomainEntity.getAmountPeople(),
                reservationDomainEntity.getStatus()
        );
    }

    public static List<ReservationEntity> toEntity(final List<ReservationDomainEntity> entities) {
        return entities.stream().map(ReservationMapper::toEntity).toList();
    }

    public static List<ReservationDomainEntity> toDomainEntity(final List<ReservationEntity> entities) {
        return entities.stream().map(ReservationMapper::toDomainEntity).toList();
    }

    public static ReservationDomainEntity toDomainEntity(final ReservationEntity reservationEntity) {
        return new ReservationDomainEntity(
                reservationEntity.getReservationId(),
                reservationEntity.getReservationName(),
                reservationEntity.getReservationEmail(),
                reservationEntity.getReservationPhone(),
                reservationEntity.getReservationTime(),
                reservationEntity.getAmountPeople(),
                RestaurantMapper.toDomainEntity(reservationEntity.getRestaurantEntity()),
                ReservationStatusEnum.fromString(reservationEntity.getStatus().toString())
        );
    }

    public static ReservationDomainEntity toDomainEntity(
            final ReservationDomainEntity reservationDomainEntity,
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        return new ReservationDomainEntity(
                reservationDomainEntity.getReservationName(),
                reservationDomainEntity.getReservationEmail(),
                reservationDomainEntity.getReservationPhone(),
                reservationDomainEntity.getReservationTime(),
                reservationDomainEntity.getAmountPeople(),
                restaurantDomainEntity,
                ReservationStatusEnum.fromString(reservationDomainEntity.getStatus().toString())
        );
    }

    public static ReservationDomainEntity toDomainEntity(
            final ReservationRequestDTO reservationRequestDTO
    ) {
        return new ReservationDomainEntity(
                reservationRequestDTO.getReservationName(),
                reservationRequestDTO.getReservationEmail(),
                reservationRequestDTO.getReservationPhone(),
                reservationRequestDTO.getReservationTime(),
                reservationRequestDTO.getAmountPeople(),
                reservationRequestDTO.getRestaurantId(),
                ReservationStatusEnum.fromString(reservationRequestDTO.getStatus())
        );
    }

    public static ReservationResponseDTO toResponseDTO(
            final ReservationDomainEntity reservationDomainEntity
    ) {
        return new ReservationResponseDTO(
                reservationDomainEntity.getReservationId(),
                reservationDomainEntity.getReservationName(),
                reservationDomainEntity.getReservationEmail(),
                reservationDomainEntity.getReservationPhone(),
                reservationDomainEntity.getReservationTime(),
                reservationDomainEntity.getAmountPeople(),
                RestaurantMapper.toResponse(reservationDomainEntity.getRestaurantDomainEntity()),
                ReservationStatusEnum.fromString(reservationDomainEntity.getStatus().toString())
        );
    }

    public static List<ReservationResponseDTO> toResponseDTO(
            final List<ReservationDomainEntity> reservationDomainEntity
    ) {
        return reservationDomainEntity.stream().map(ReservationMapper::toResponseDTO).toList();
    }
}
