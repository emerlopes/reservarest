package com.fiap.reservarest.domain.booking.usecase.impl;

import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.booking.usecase.BookingUseCase;

public class BookingUseCaseImpl implements BookingUseCase {

    private final BookingService bookingService;

    public BookingUseCaseImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public BookingDomainEntity execute(BookingDomainEntity bookingDomainEntity) {
        return bookingService.booking(bookingDomainEntity);
    }
}
