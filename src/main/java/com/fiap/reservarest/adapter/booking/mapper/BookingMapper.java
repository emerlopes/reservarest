package com.fiap.reservarest.adapter.booking.mapper;

import com.fiap.reservarest.adapter.booking.entity.BookingEntity;
import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;

public class BookingMapper {

    public static BookingEntity toEntity(BookingDomainEntity bookingDomainEntity) {
        return new BookingEntity(
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationTime(),
                RestaurantMapper.toEntity(bookingDomainEntity.getRestaurantDomainEntity()),
                bookingDomainEntity.getAmountPeople()
        );
    }

    public static BookingDomainEntity toDomainEntity(BookingEntity bookingEntity) {
        return new BookingDomainEntity(
                bookingEntity.getReservationId(),
                bookingEntity.getReservationName(),
                bookingEntity.getReservationTime(),
                bookingEntity.getAmountPeople(),
                RestaurantMapper.toDomainEntity(bookingEntity.getRestaurantEntity())
        );
    }
}
