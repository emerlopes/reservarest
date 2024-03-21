package com.fiap.reservarest.adapter.booking.mapper;

import com.fiap.reservarest.adapter.booking.entity.BookingEntity;
import com.fiap.reservarest.adapter.booking.entity.BookingStatusEnum;
import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingResponseDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.time.LocalDateTime;
import java.util.List;

public class BookingMapper {

    public static BookingEntity toEntity(final BookingDomainEntity bookingDomainEntity) {
        return new BookingEntity(
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationEmail(),
                bookingDomainEntity.getReservationPhone(),
                bookingDomainEntity.getReservationTime(),
                RestaurantMapper.toEntity(bookingDomainEntity.getRestaurantDomainEntity()),
                bookingDomainEntity.getAmountPeople(),
                bookingDomainEntity.getStatus()
        );
    }

    public static List<BookingEntity> toEntity(final List<BookingDomainEntity> entities) {
        return entities.stream().map(BookingMapper::toEntity).toList();
    }

    public static BookingDomainEntity toDomainEntity(final BookingEntity bookingEntity) {
        return new BookingDomainEntity(
                bookingEntity.getReservationId(),
                bookingEntity.getReservationName(),
                bookingEntity.getReservationEmail(),
                bookingEntity.getReservationPhone(),
                bookingEntity.getReservationTime(),
                bookingEntity.getAmountPeople(),
                RestaurantMapper.toDomainEntity(bookingEntity.getRestaurantEntity()),
                bookingEntity.getStatus()
        );
    }

    public static BookingDomainEntity toDomainEntity(
            final BookingDomainEntity bookingDomainEntity,
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        return new BookingDomainEntity(
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationEmail(),
                bookingDomainEntity.getReservationPhone(),
                bookingDomainEntity.getReservationTime(),
                bookingDomainEntity.getAmountPeople(),
                restaurantDomainEntity,
                bookingDomainEntity.getStatus()
        );
    }

    public static BookingDomainEntity toDomainEntity(
            final BookingRequestDTO bookingRequestDTO
    ) {
        return new BookingDomainEntity(
                bookingRequestDTO.getReservationName(),
                bookingRequestDTO.getReservationEmail(),
                bookingRequestDTO.getReservationPhone(),
                bookingRequestDTO.getReservationTime(),
                bookingRequestDTO.getAmountPeople(),
                bookingRequestDTO.getRestaurantId(),
                bookingRequestDTO.getStatus()
        );
    }

    public static CustomResponse<BookingResponseDTO> toResponseDTO(
            final BookingDomainEntity bookingDomainEntity
    ) {
        final var response = new BookingResponseDTO(
                bookingDomainEntity.getBookingId(),
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationEmail(),
                bookingDomainEntity.getReservationPhone(),
                bookingDomainEntity.getReservationTime(),
                bookingDomainEntity.getAmountPeople(),
                RestaurantMapper.toResponse(bookingDomainEntity.getRestaurantDomainEntity()),
                bookingDomainEntity.getStatus()
        );

        return new CustomResponse<BookingResponseDTO>().setData(response);
    }
}
