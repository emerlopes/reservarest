package com.fiap.reservarest.adapter.restaurant;

import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.adapter.restaurant.repository.RestaurantRepository;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantDomainEntity createRestaurant(RestaurantDomainEntity restaurantDomainEntity) {
        final var entity = RestaurantMapper.toEntity(restaurantDomainEntity);
        final var domainEntity = restaurantRepository.save(entity);

        return RestaurantMapper.toDomainEntity(domainEntity);
    }

    @PostConstruct
    public void init() {
        if (restaurantRepository.count() == 0) {
            RestaurantDomainEntity restaurantDomainEntity = new RestaurantDomainEntity(
                    UUID.randomUUID(),
                    "Restaurante da Maria",
                    "Rua 1, 123",
                    "Brasileira",
                    8.0,
                    48,
                    LocalDateTime.now()
            );
            restaurantRepository.save(RestaurantMapper.toEntity(restaurantDomainEntity));
        }
    }
}
