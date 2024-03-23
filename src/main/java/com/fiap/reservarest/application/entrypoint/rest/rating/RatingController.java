package com.fiap.reservarest.application.entrypoint.rest.rating;

import com.fiap.reservarest.adapter.rating.mapper.RatingMapper;
import com.fiap.reservarest.application.entrypoint.rest.rating.dto.RatingRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.rating.dto.RatingResponseDTO;
import com.fiap.reservarest.domain.rating.usecase.RatingCreationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingCreationUseCase ratingCreationUseCase;

    public RatingController(
            final RatingCreationUseCase ratingCreationUseCase
    ) {
        this.ratingCreationUseCase = ratingCreationUseCase;
    }

    @PostMapping
    public ResponseEntity<RatingResponseDTO> createRating(@RequestBody RatingRequestDTO request) {
        final var ratingDomainEntity = RatingMapper.toDomainEntity(request);
        final var response = ratingCreationUseCase.execute(ratingDomainEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(RatingMapper.toResponse(response));
    }

}
