package com.fiap.reservarest.adapter.booking;

import com.fiap.reservarest.adapter.booking.mapper.BookingMapper;
import com.fiap.reservarest.adapter.booking.repository.BookingRepository;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.service.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDomainEntity booking(BookingDomainEntity bookingDomainEntity) {
        final var entity = BookingMapper.toEntity(bookingDomainEntity);
        final var savedEntity = bookingRepository.save(entity);

        return BookingMapper.toDomainEntity(savedEntity);
    }
}
