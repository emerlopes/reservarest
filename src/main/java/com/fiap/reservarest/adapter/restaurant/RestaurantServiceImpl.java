package com.fiap.reservarest.adapter.restaurant;

import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.adapter.restaurant.repository.RestaurantRepository;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public List<RestaurantDomainEntity> findRestaurantByKeyWord(String restaurant) {
        final var entities = restaurantRepository.findRestaurantsByKeyword(restaurant);
        return RestaurantMapper.toDomainEntity(entities);
    }

    @Override
    public List<RestaurantDomainEntity> findRestaurants() {
        final var entities = restaurantRepository.findAll();
        return RestaurantMapper.toDomainEntity(entities);
    }

    @PostConstruct
    public void init() {
        if (restaurantRepository.count() == 0) {

            for (final var restaurant : RestaurantsEnum.values()) {

                RestaurantDomainEntity restaurantDomainEntity = new RestaurantDomainEntity(
                        UUID.randomUUID(),
                        restaurant.getName(),
                        restaurant.getLocation(),
                        restaurant.getCuisineType().toString(),
                        8.0,
                        restaurant.getCapacity(),
                        LocalDateTime.now()
                );
                restaurantRepository.save(RestaurantMapper.toEntity(restaurantDomainEntity));
            }

        }
    }
}
