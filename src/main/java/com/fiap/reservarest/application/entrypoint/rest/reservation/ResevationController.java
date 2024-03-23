package com.fiap.reservarest.application.entrypoint.rest.reservation;


import com.fiap.reservarest.adapter.reservation.mapper.ReservationMapper;
import com.fiap.reservarest.adapter.reservation.mapper.ReservationSearchMapper;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.ReservationRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.reservation.dto.UpdateReservationRequestDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByRestaurantUseCase;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
import com.fiap.reservarest.domain.reservation.usecase.UpdateReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("reservations")
public class ResevationController {

    private final ReservationUseCase reservationUseCase;
    private final UpdateReservationUseCase updateReservationUseCase;
    private final ReservationSearchByRestaurantUseCase reservationSearchByRestaurantUseCase;

    public ResevationController(
            final ReservationUseCase reservationUseCase,
            final UpdateReservationUseCase updateReservationUseCase,
            final ReservationSearchByRestaurantUseCase reservationSearchByRestaurantUseCase
    ) {
        this.reservationUseCase = reservationUseCase;
        this.updateReservationUseCase = updateReservationUseCase;
        this.reservationSearchByRestaurantUseCase = reservationSearchByRestaurantUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomResponse<Object>> reservationTable(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        final var domainEntity = ReservationMapper.toDomainEntity(reservationRequestDTO);
        final var response = reservationUseCase.execute(domainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse<>().setData(ReservationMapper.toResponseDTO(response)));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateReservation(@Valid @RequestBody UpdateReservationRequestDTO updateReservationRequestDTO) {
        final var domainEntity = ReservationMapper.toDomainEntity(updateReservationRequestDTO);
        final var response = updateReservationUseCase.execute(domainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse<>().setData(ReservationMapper.toResponseDTO(response)));
    }

    @GetMapping("/restaurants/{restaurantExternalId}")
    public ResponseEntity<?> getReservationsByRestaurant(@PathVariable String restaurantExternalId) {
        final var domainEntity = ReservationSearchMapper.toDomainEntity(UUID.fromString(restaurantExternalId));
        final var output = reservationSearchByRestaurantUseCase.execute(domainEntity);

        final var response = ReservationMapper.toResponseDTO(output);

        if (output.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT).body(response);

        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse<>().setData(response));
    }
}
