package com.fiap.reservarest.application.entrypoint.rest.booking;


import com.fiap.reservarest.adapter.reservation.mapper.ReservationMapper;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
public class BookingController {

    private final ReservationUseCase reservationUseCase;

    public BookingController(ReservationUseCase reservationUseCase) {
        this.reservationUseCase = reservationUseCase;
    }

    @PostMapping
    public ResponseEntity<?> booking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
        final var domainEntity = ReservationMapper.toDomainEntity(bookingRequestDTO);
        final var response = reservationUseCase.execute(domainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(ReservationMapper.toResponseDTO(response));
    }
}
