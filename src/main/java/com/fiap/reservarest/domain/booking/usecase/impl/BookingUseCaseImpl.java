package com.fiap.reservarest.domain.booking.usecase.impl;

import com.fiap.reservarest.adapter.booking.mapper.BookingMapper;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.booking.usecase.BookingUseCase;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.springframework.transaction.annotation.Transactional;

public class BookingUseCaseImpl implements BookingUseCase {

    private final BookingService bookingService;
    private final RestaurantService restaurantService;

    public BookingUseCaseImpl(
            final BookingService bookingService,
            final RestaurantService restaurantService
    ) {
        this.bookingService = bookingService;
        this.restaurantService = restaurantService;
    }

    @Override
    @Transactional
    public BookingDomainEntity execute(BookingDomainEntity bookingDomainEntity) {
        final var restaurantExternalId = bookingDomainEntity.getRestaurantExternalId();
        final var restaurantDomainEntity = restaurantService.findByExternalId(restaurantExternalId);
        final var domainEntity = BookingMapper.toDomainEntity(bookingDomainEntity, restaurantDomainEntity);

        bookingService.updateQuantityTableByPeople(domainEntity);

        return bookingService.booking(domainEntity);
    }
}
