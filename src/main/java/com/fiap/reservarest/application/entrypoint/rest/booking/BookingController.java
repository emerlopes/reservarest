package com.fiap.reservarest.application.entrypoint.rest.booking;


import com.fiap.reservarest.adapter.booking.mapper.BookingMapper;
import com.fiap.reservarest.application.entrypoint.rest.booking.dto.BookingRequestDTO;
import com.fiap.reservarest.domain.booking.usecase.BookingUseCase;
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

    private final BookingUseCase bookingUseCase;

    public BookingController(BookingUseCase bookingUseCase) {
        this.bookingUseCase = bookingUseCase;
    }

    @PostMapping
    public ResponseEntity<?> booking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
        final var domainEntity = BookingMapper.toDomainEntity(bookingRequestDTO);
        final var response = bookingUseCase.execute(domainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(BookingMapper.toResponseDTO(response));
    }
}
