package com.fiap.reservarest.adapter.reservation;

import com.fiap.reservarest.adapter.reservation.entity.ReservationEntity;
import com.fiap.reservarest.adapter.reservation.entity.ReservationStatusEnum;
import com.fiap.reservarest.adapter.reservation.repository.ReservationRepository;
import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import com.fiap.reservarest.domain.reservation.entity.ReservationDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class ReservationServiceImplTest {

    @InjectMocks
    private ReservationServiceImpl bookingService;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void bookingShouldReturnBookingWhenBookingIsSuccessful() {
        // Arrange
        final String reservationName = "Teste";
        final LocalDateTime reservationTime = LocalDateTime.now();
        final int numberOfPeople = 2;

        RestaurantDomainEntity restaurant = new RestaurantDomainEntity(
                UUID.randomUUID(),
                "Teste",
                "Teste",
                "Teste",
                8.0,
                2,
                LocalDateTime.now()
        );

        ReservationDomainEntity reservationDomainEntity = new ReservationDomainEntity(
                reservationName,
                "email",
                "phone",
                reservationTime,
                numberOfPeople,
                restaurant,
                ReservationStatusEnum.PENDING
        );

        ReservationEntity reservationEntity = new ReservationEntity(
                reservationName,
                "email",
                "phone",
                reservationTime,
                new RestaurantEntity(
                        restaurant.getExternalId(),
                        restaurant.getName(),
                        restaurant.getLocation(),
                        restaurant.getCuisineType(),
                        restaurant.getHoursOfOperation(),
                        restaurant.getTables(),
                        restaurant.getCreateAt()
                ),
                numberOfPeople,
                ReservationStatusEnum.PENDING
        );

        when(reservationRepository.save(any())).thenReturn(reservationEntity);

        // Act
        ReservationDomainEntity result = bookingService.reservation(reservationDomainEntity);

        // Assert
        verify(reservationRepository, times(1)).save(any());
        assertThat(result).isNotNull();
    }
}