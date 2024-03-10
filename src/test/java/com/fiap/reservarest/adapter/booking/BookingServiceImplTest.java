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

        final var uuid = UUID.randomUUID();

        BookingDomainEntity bookingDomainEntity = new BookingDomainEntity(
                "Teste",
                LocalDateTime.now(),
                2,
                new RestaurantDomainEntity(
                        UUID.randomUUID(),
                        "Teste",
                        "Teste",
                        "Teste",
                        8.0,
                        2,
                        LocalDateTime.now()

                ));

        final var bookingEntity = new BookingEntity(
                bookingDomainEntity.getReservationName(),
                bookingDomainEntity.getReservationTime(),
                new RestaurantEntity(
                        uuid,
                        "Teste",
                        "Teste",
                        "Teste",
                        8.0,
                        2,
                        LocalDateTime.now()
                ),
                2
        );


        when(bookingRepository.save(any())).thenReturn(bookingEntity);

        BookingDomainEntity result = bookingService.booking(bookingDomainEntity);

        verify(bookingRepository, times(1)).save(any());
        Assertions.assertThat(result).isNotNull();
    }

}