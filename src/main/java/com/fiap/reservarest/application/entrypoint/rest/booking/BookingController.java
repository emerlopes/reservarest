package com.fiap.reservarest.application.entrypoint.rest.booking;


import com.fiap.reservarest.adapter.reservation.mapper.ReservationMapper;
import com.fiap.reservarest.adapter.reservation.mapper.ReservationSearchMapper;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.reservation.entity.ReservationSearchByRestaurantDomainEntity;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByRestaurantUseCase;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("bookings")
public class BookingController {

    private final ReservationUseCase reservationUseCase;
    private final ReservationSearchByRestaurantUseCase reservationSearchByRestaurantUseCase;

    public BookingController(
            final ReservationUseCase reservationUseCase,
            final ReservationSearchByRestaurantUseCase reservationSearchByRestaurantUseCase
    ) {
        this.reservationUseCase = reservationUseCase;
        this.reservationSearchByRestaurantUseCase = reservationSearchByRestaurantUseCase;
    }

    @PostMapping
    public ResponseEntity<?> booking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
        final var domainEntity = ReservationMapper.toDomainEntity(bookingRequestDTO);
        final var response = reservationUseCase.execute(domainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse<>().setData(ReservationMapper.toResponseDTO(response)));
    }

    @GetMapping("/restaurants/{restaurantExternalId}")
    public ResponseEntity<?> getReservationsByRestaurant(@PathVariable String restaurantExternalId) {
        final var domainEntity = ReservationSearchMapper.toDomainEntity(UUID.fromString(restaurantExternalId));
        final var response = reservationSearchByRestaurantUseCase.execute(domainEntity);

        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse<>().setData(ReservationMapper.toResponseDTO(response)));
    }
}
