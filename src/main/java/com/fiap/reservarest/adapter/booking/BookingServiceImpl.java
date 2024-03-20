package com.fiap.reservarest.adapter.booking;

import com.fiap.reservarest.adapter.booking.entity.BookingStatusEnum;
import com.fiap.reservarest.adapter.booking.mapper.BookingMapper;
import com.fiap.reservarest.adapter.booking.repository.BookingRepository;
import com.fiap.reservarest.adapter.rating.mapper.RatingMapper;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.exception.BookingDomainCustomException;
import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @PostConstruct
    public void init() {
        logger.info("BookingServiceImpl started");

        if (bookingRepository.count() == 0) {
            logger.info("Creating default bookings");

            final var RestauranteNonna = restaurantService.findByExternalId(UUID.fromString("6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5"));
            final var RestauranteSushiExpress = restaurantService.findByExternalId(UUID.fromString("552093ec-7887-4dff-a706-becf408defab"));
            final var RestauranteTaqueriaDelSol = restaurantService.findByExternalId(UUID.fromString("10a4dc3b-b775-4dc9-82d5-ba54398cced6"));
            final var RestauranteBurgerHaven = restaurantService.findByExternalId(UUID.fromString("efb7230d-4b4c-4c20-9a3d-87d248820562"));
            final var RestauranteTajMahal = restaurantService.findByExternalId(UUID.fromString("48d87425-79b4-436e-9eb6-9c2e3b96c855"));
            final var RestauranteComidaDaVovo = restaurantService.findByExternalId(UUID.fromString("09e849a2-c62b-4dfe-837c-0283588a1e01"));

            final var booking1 = new BookingDomainEntity(
                    "John Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    4,
                    RestauranteNonna,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking11 = new BookingDomainEntity(
                    "John Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    4,
                    RestauranteNonna,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking2 = new BookingDomainEntity(
                    "Karl Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    2,
                    RestauranteSushiExpress,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking22 = new BookingDomainEntity(
                    "Karl Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    2,
                    RestauranteSushiExpress,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking3 = new BookingDomainEntity(
                    "Zack Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(2),
                    4,
                    RestauranteTaqueriaDelSol,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking33 = new BookingDomainEntity(
                    "Zack Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(2),
                    4,
                    RestauranteTaqueriaDelSol,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking4 = new BookingDomainEntity(
                    "Frank Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(2),
                    2,
                    RestauranteBurgerHaven,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking5 = new BookingDomainEntity(
                    "Jack Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(3),
                    4,
                    RestauranteTajMahal,
                    BookingStatusEnum.CONFIRMED
            );

            final var booking6 = new BookingDomainEntity(
                    "Yuri Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(3),
                    2,
                    RestauranteComidaDaVovo,
                    BookingStatusEnum.CONFIRMED
            );

            bookingRepository.saveAll(
                    BookingMapper.toEntity(
                            List.of(
                                    booking1, booking11, booking2, booking22, booking3, booking33, booking4, booking5, booking6
                            )
                    )
            );
        }
    }
}
