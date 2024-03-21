package com.fiap.reservarest.adapter.reservation.mapper;

import com.fiap.reservarest.adapter.reservation.entity.ReservationEntity;
import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingResponseDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
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
                reservationEntity.getStatus()
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
                reservationDomainEntity.getStatus()
        );
    }

    public static ReservationDomainEntity toDomainEntity(
            final BookingRequestDTO bookingRequestDTO
    ) {
        return new ReservationDomainEntity(
                bookingRequestDTO.getReservationName(),
                bookingRequestDTO.getReservationEmail(),
                bookingRequestDTO.getReservationPhone(),
                bookingRequestDTO.getReservationTime(),
                bookingRequestDTO.getAmountPeople(),
                bookingRequestDTO.getRestaurantId(),
                bookingRequestDTO.getStatus()
        );
    }

    public static BookingResponseDTO toResponseDTO(
            final ReservationDomainEntity reservationDomainEntity
    ) {
        return new BookingResponseDTO(
                reservationDomainEntity.getReservationId(),
                reservationDomainEntity.getReservationName(),
                reservationDomainEntity.getReservationEmail(),
                reservationDomainEntity.getReservationPhone(),
                reservationDomainEntity.getReservationTime(),
                reservationDomainEntity.getAmountPeople(),
                RestaurantMapper.toResponse(reservationDomainEntity.getRestaurantDomainEntity()),
                reservationDomainEntity.getStatus()
        );
    }

    public static List<BookingResponseDTO> toResponseDTO(
            final List<ReservationDomainEntity> reservationDomainEntity
    ) {
        return reservationDomainEntity.stream().map(ReservationMapper::toResponseDTO).toList();
    }
}
