package com.fiap.reservarest.domain.booking.usecase.impl;

import com.fiap.reservarest.domain.booking.entity.BookingDomainEntity;
import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BookingUseCaseImplTest {

    @InjectMocks
    private BookingUseCaseImpl bookingUseCase;

    @Mock
    private BookingService bookingService;

    @Mock
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void executeShouldReturnBookingWhenRestaurantExistsAndBookingIsSuccessful() {
        // Arrange
        UUID restaurantId = UUID.randomUUID();

        BookingDomainEntity bookingDomainEntity = new BookingDomainEntity(
                "Teste",
                LocalDateTime.now(),
                2,
                restaurantId
        );

        RestaurantDomainEntity restaurantDomainEntity = new RestaurantDomainEntity();

        when(restaurantService.findByExternalId(restaurantId)).thenReturn(restaurantDomainEntity);
        when(bookingService.booking(any(BookingDomainEntity.class))).thenReturn(bookingDomainEntity);

        // Act
        BookingDomainEntity result = bookingUseCase.execute(bookingDomainEntity);

        // Assert
        verify(restaurantService, times(1)).findByExternalId(restaurantId);
        verify(bookingService, times(1)).booking(any(BookingDomainEntity.class));
        assertEquals(bookingDomainEntity, result);
    }

    
}