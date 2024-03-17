package com.fiap.reservarest.adapter.booking;

import com.fiap.reservarest.adapter.booking.entity.BookingEntity;
import com.fiap.reservarest.adapter.booking.repository.BookingRepository;
import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class BookingServiceImplTest {

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

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

        BookingDomainEntity bookingDomainEntity = new BookingDomainEntity(
                reservationName,
                reservationTime,
                numberOfPeople,
                restaurant
        );

        BookingEntity bookingEntity = new BookingEntity(
                reservationName,
                reservationTime,
                new RestaurantEntity(
                        restaurant.getExternalId(),
                        restaurant.getName(),
                        restaurant.getLocation(),
                        restaurant.getCuisineType(),
                        restaurant.getHoursOfOperation(),
                        restaurant.getCapacity(),
                        restaurant.getCreateAt()
                ),
                numberOfPeople
        );

        when(bookingRepository.save(any())).thenReturn(bookingEntity);

        // Act
        BookingDomainEntity result = bookingService.booking(bookingDomainEntity);

        // Assert
        verify(bookingRepository, times(1)).save(any());
        assertThat(result).isNotNull();
    }
}