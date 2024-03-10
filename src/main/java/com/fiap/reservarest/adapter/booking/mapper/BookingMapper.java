package com.fiap.reservarest.adapter.booking.mapper;

import com.fiap.reservarest.adapter.booking.entity.BookingEntity;
import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingResponseDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

public class BookingMapper {

    public static BookingEntity toEntity(final BookingDomainEntity bookingDomainEntity) {
        return new BookingEntity(
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationTime(),
                RestaurantMapper.toEntity(bookingDomainEntity.getRestaurantDomainEntity()),
                bookingDomainEntity.getAmountPeople()
        );
    }

    public static BookingDomainEntity toDomainEntity(final BookingEntity bookingEntity) {
        return new BookingDomainEntity(
                bookingEntity.getReservationId(),
                bookingEntity.getReservationName(),
                bookingEntity.getReservationTime(),
                bookingEntity.getAmountPeople(),
                RestaurantMapper.toDomainEntity(bookingEntity.getRestaurantEntity())
        );
    }

    public static BookingDomainEntity toDomainEntity(
            final BookingDomainEntity bookingDomainEntity,
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        return new BookingDomainEntity(
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationTime(),
                bookingDomainEntity.getAmountPeople(),
                restaurantDomainEntity
        );
    }

    public static BookingDomainEntity toDomainEntity(
            final BookingRequestDTO bookingRequestDTO
    ) {
        return new BookingDomainEntity(
                bookingRequestDTO.getReservationName(),
                bookingRequestDTO.getReservationTime(),
                bookingRequestDTO.getAmountPeople(),
                bookingRequestDTO.getRestaurantId()
        );
    }

    public static CustomResponse<BookingResponseDTO> toResponseDTO(
            final BookingDomainEntity bookingDomainEntity
    ) {
        final var response = new BookingResponseDTO(
                bookingDomainEntity.getBookingId(),
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationTime(),
                bookingDomainEntity.getAmountPeople(),
                RestaurantMapper.toResponse(bookingDomainEntity.getRestaurantDomainEntity()
                )
        );

        return new CustomResponse<BookingResponseDTO>().setData(response);
    }
}
