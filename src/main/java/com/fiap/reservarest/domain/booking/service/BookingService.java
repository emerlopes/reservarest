package com.fiap.reservarest.domain.booking.service;

import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

public interface BookingService {
    BookingDomainEntity booking(BookingDomainEntity bookingDomainEntity);

    void updateQuantityTableByPeople(BookingDomainEntity bookingDomainEntity);

}
