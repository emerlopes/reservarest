package com.fiap.reservarest.application.entrypoint.rest.restaurant;

import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantSearchUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCreationUseCase restaurantCreationUseCase;
    private final RestaurantSearchUseCase restaurantSearchUseCase;

    public RestaurantController(RestaurantCreationUseCase restaurantCreationUseCase, RestaurantSearchUseCase restaurantSearchUseCase) {
        this.restaurantCreationUseCase = restaurantCreationUseCase;
        this.restaurantSearchUseCase = restaurantSearchUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomResponse<RestaurantResponseDTO>> createRestaurant(
            final @Valid @RequestBody RestaurantRequestDTO restaurantRequestDTO
    ) {
        final var domainEntity = RestaurantMapper.toDomainEntity(restaurantRequestDTO);
        final var output = restaurantCreationUseCase.execute(domainEntity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(RestaurantMapper.toResponseDTO(output));
    }

    @GetMapping("/search")
    public ResponseEntity<CustomResponse<List<RestaurantResponseDTO>>> searchRestaurant(
            @RequestParam(required = false) final String keyword
    ) {
        final var domainEntity = RestaurantMapper.toDomainEntity(keyword);
        final var output = restaurantSearchUseCase.execute(domainEntity);

        final var response = RestaurantMapper.toResponseDTO(output);

        if (output.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT).body(response);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
