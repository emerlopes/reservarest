package com.fiap.reservarest.adapter.restaurant;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import com.fiap.reservarest.adapter.restaurant.repository.RestaurantRepository;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceImplTest {

    @InjectMocks
    private RestaurantServiceImpl restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    private final UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

    private final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2021, 10, 10, 10, 10, 10, 10);


    @Test
    void shouldCreateRestaurant() {

        // Arrange
        RestaurantDomainEntity restaurantDomainEntity = createRestaurantDomainEntity(
                "Restaurante da Maria",
                "Rua 1, 123",
                "Brasileira",
                8.0,
                48
        );

        RestaurantEntity restaurantEntity = createRestaurantEntity(
                "Restaurante da Maria",
                "Rua 1, 123",
                "Brasileira",
                8.0,
                48
        );
        Mockito.when(restaurantRepository.save(Mockito.any(RestaurantEntity.class))).thenReturn(restaurantEntity);

        // Act
        final var result = restaurantService.createRestaurant(restaurantDomainEntity);

        // Assert
        assertThat(result).isNotNull();

    }

    private RestaurantDomainEntity createRestaurantDomainEntity(
            String name,
            String location,
            String cuisineType,
            Double hoursOfOperation,
            Integer capacity
    ) {
        return new RestaurantDomainEntity(
                uuid,
                name,
                location,
                cuisineType,
                hoursOfOperation,
                capacity,
                LOCAL_DATE_TIME
        );
    }

    private RestaurantEntity createRestaurantEntity(
            String name,
            String location,
            String cuisineType,
            Double hoursOfOperation,
            Integer capacity
    ) {
        return new RestaurantEntity(
                uuid,
                name,
                location,
                cuisineType,
                hoursOfOperation,
                capacity,
                LOCAL_DATE_TIME
        );
    }

}