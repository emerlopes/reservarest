package com.fiap.reservarest.adapter.reservation;

import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.adapter.reservation.mapper.ReservationMapper;
import com.fiap.reservarest.adapter.reservation.repository.ReservationRepository;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByIdDomainEntity;
import com.fiap.reservarest.domain.reservation.exception.ReservationDomainCustomException;
import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final Logger logger;

    private final ReservationRepository reservationRepository;
    private final RestaurantService restaurantService;

    private final int QUANTITY_PEOPLE_PER_TABLE = 4;


    public ReservationServiceImpl(
            final Logger logger,
            final ReservationRepository reservationRepository,
            final RestaurantService restaurantService
    ) {
        this.logger = logger;
        this.reservationRepository = reservationRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public ReservationDomainEntity reservation(ReservationDomainEntity reservationDomainEntity) {
        final var entity = ReservationMapper.toEntity(reservationDomainEntity);
        final var savedEntity = reservationRepository.save(entity);

        return ReservationMapper.toDomainEntity(savedEntity);
    }

    @Override
    public ReservationDomainEntity findReservationById(ReservationSearchByIdDomainEntity reservationSearchByIdDomainEntity) {
        final var entity = reservationRepository.findById(reservationSearchByIdDomainEntity.getReservationId());
        return ReservationMapper.toDomainEntity(entity.orElseThrow(() -> new ReservationDomainCustomException("Reservation not found")));
    }

    @Override
    public List<ReservationDomainEntity> findReservationByRestaurantId(Long restaurantId) {
        final var entities = reservationRepository.findByRestaurantEntityRestaurantId(restaurantId);
        return ReservationMapper.toDomainEntity(entities);
    }

    @Override
    public void updateQuantityTableByPeople(ReservationDomainEntity reservationDomainEntity) {

        logger.info("Updating quantity table by people");

        final var amountPeople = reservationDomainEntity.getAmountPeople();
        final var quantityTable = reservationDomainEntity.getRestaurantDomainEntity().getCapacity();
        final var aviableTables = calculateTableByPeople(amountPeople, quantityTable);

        logger.info("Aviable tables: {}", aviableTables);

        if (aviableTables < 0) {
            logger.error("There are no tables available for this amount of people: {}", amountPeople);
            throw new ReservationDomainCustomException("There are no tables available for this amount of people");
        }

        reservationDomainEntity.getRestaurantDomainEntity().setCapacity(aviableTables);

        restaurantService.saveRestaurant(reservationDomainEntity.getRestaurantDomainEntity());
    }

    private Integer calculateTableByPeople(Integer amountPeople, int quantityTable) {
        final var reservedTables = (int) Math.ceil((double) amountPeople / QUANTITY_PEOPLE_PER_TABLE);

        return quantityTable - reservedTables;
    }

    @PostConstruct
    public void init() {
        logger.info("BookingServiceImpl started");

        if (reservationRepository.count() == 0) {
            logger.info("Creating default bookings");

            final var RestauranteNonna = restaurantService.findByExternalId(UUID.fromString("6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5"));
            final var RestauranteSushiExpress = restaurantService.findByExternalId(UUID.fromString("552093ec-7887-4dff-a706-becf408defab"));
            final var RestauranteTaqueriaDelSol = restaurantService.findByExternalId(UUID.fromString("10a4dc3b-b775-4dc9-82d5-ba54398cced6"));
            final var RestauranteBurgerHaven = restaurantService.findByExternalId(UUID.fromString("efb7230d-4b4c-4c20-9a3d-87d248820562"));
            final var RestauranteTajMahal = restaurantService.findByExternalId(UUID.fromString("48d87425-79b4-436e-9eb6-9c2e3b96c855"));
            final var RestauranteComidaDaVovo = restaurantService.findByExternalId(UUID.fromString("09e849a2-c62b-4dfe-837c-0283588a1e01"));

            final var booking1 = new ReservationDomainEntity(
                    "John Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    4,
                    RestauranteNonna,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking11 = new ReservationDomainEntity(
                    "John Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    4,
                    RestauranteNonna,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking2 = new ReservationDomainEntity(
                    "Karl Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    2,
                    RestauranteSushiExpress,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking22 = new ReservationDomainEntity(
                    "Karl Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(1),
                    2,
                    RestauranteSushiExpress,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking3 = new ReservationDomainEntity(
                    "Zack Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(2),
                    4,
                    RestauranteTaqueriaDelSol,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking33 = new ReservationDomainEntity(
                    "Zack Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(2),
                    4,
                    RestauranteTaqueriaDelSol,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking4 = new ReservationDomainEntity(
                    "Frank Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(2),
                    2,
                    RestauranteBurgerHaven,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking5 = new ReservationDomainEntity(
                    "Jack Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(3),
                    4,
                    RestauranteTajMahal,
                    ReservationStatusEnum.CONFIRMED
            );

            final var booking6 = new ReservationDomainEntity(
                    "Yuri Doe",
                    "email",
                    "phone",
                    LocalDateTime.now().plusDays(3),
                    2,
                    RestauranteComidaDaVovo,
                    ReservationStatusEnum.CONFIRMED
            );

            reservationRepository.saveAll(
                    ReservationMapper.toEntity(
                            List.of(
                                    booking1, booking11, booking2, booking22, booking3, booking33, booking4, booking5, booking6
                            )
                    )
            );
        }
    }
}
