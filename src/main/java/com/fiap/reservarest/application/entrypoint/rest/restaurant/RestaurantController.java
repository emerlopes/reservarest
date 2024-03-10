package com.fiap.reservarest.application.entrypoint.rest.restaurant;

import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCreationUseCase restaurantCreationUseCase;

    public RestaurantController(RestaurantCreationUseCase restaurantCreationUseCase) {
        this.restaurantCreationUseCase = restaurantCreationUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createRestaurant(
            final @Valid @RequestBody RestaurantRequestDTO restaurantRequestDTO
    ) {
        final var domainEntity = RestaurantMapper.toDomainEntity(restaurantRequestDTO);
        final var output = restaurantCreationUseCase.execute(domainEntity);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(RestaurantMapper.toResponseDTO(output));
    }
}
