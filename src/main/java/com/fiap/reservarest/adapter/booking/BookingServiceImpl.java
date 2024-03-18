package com.fiap.reservarest.adapter.booking;

import com.fiap.reservarest.adapter.booking.mapper.BookingMapper;
import com.fiap.reservarest.adapter.booking.repository.BookingRepository;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.exception.BookingDomainCustomException;
import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BookingServiceImpl implements BookingService {

    private final Logger logger;

    private final BookingRepository bookingRepository;
    private final RestaurantService restaurantService;

    private final int QUANTITY_PEOPLE_PER_TABLE = 4;


    public BookingServiceImpl(
            final Logger logger,
            final BookingRepository bookingRepository,
            final RestaurantService restaurantService
    ) {
        this.logger = logger;
        this.bookingRepository = bookingRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public BookingDomainEntity booking(BookingDomainEntity bookingDomainEntity) {
        final var entity = BookingMapper.toEntity(bookingDomainEntity);
        final var savedEntity = bookingRepository.save(entity);

        return BookingMapper.toDomainEntity(savedEntity);
    }

    @Override
    public void updateQuantityTableByPeople(BookingDomainEntity bookingDomainEntity) {

        logger.info("Updating quantity table by people");

        final var amountPeople = bookingDomainEntity.getAmountPeople();
        final var quantityTable = bookingDomainEntity.getRestaurantDomainEntity().getCapacity();
        final var aviableTables = calculateTableByPeople(amountPeople, quantityTable);

        logger.info("Aviable tables: {}", aviableTables);

        if (aviableTables < 0) {
            logger.error("There are no tables available for this amount of people: {}", amountPeople);
            throw new BookingDomainCustomException("There are no tables available for this amount of people");
        }

        bookingDomainEntity.getRestaurantDomainEntity().setCapacity(aviableTables);

        restaurantService.saveRestaurant(bookingDomainEntity.getRestaurantDomainEntity());
    }

    private Integer calculateTableByPeople(Integer amountPeople, int quantityTable) {
        final var reservedTables = (int) Math.ceil((double) amountPeople / QUANTITY_PEOPLE_PER_TABLE);

        return quantityTable - reservedTables;
    }
}
