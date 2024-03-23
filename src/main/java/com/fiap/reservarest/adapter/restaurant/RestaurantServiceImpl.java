package com.fiap.reservarest.adapter.restaurant;

import com.fiap.reservarest.adapter.restaurant.mapper.RestaurantMapper;
import com.fiap.reservarest.adapter.restaurant.repository.RestaurantRepository;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.exception.RestaurantDomainCustomException;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final Logger logger;

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(
            final Logger logger,
            final RestaurantRepository restaurantRepository
    ) {
        this.logger = logger;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantDomainEntity saveRestaurant(
            final RestaurantDomainEntity restaurantDomainEntity
    ) {

        logger.info("Saving restaurant: {}", restaurantDomainEntity.getName());

        final var entity = RestaurantMapper.toEntity(restaurantDomainEntity);
        final var entitySaved = restaurantRepository.save(entity);

        final var domainEntity = RestaurantMapper.toDomainEntity(entitySaved);

        logger.info("Restaurant saved: {}", domainEntity);

        return domainEntity;
    }

    @Override
    public List<RestaurantDomainEntity> findRestaurantByKeyWord(
            final String keyword
    ) {

        logger.info("Searching restaurant by keyword: {}", keyword);

        final var entities = restaurantRepository.findRestaurantsByKeyword(keyword);

        logger.info("Found {} restaurants by keyword", entities.size());

        return RestaurantMapper.toDomainEntity(entities);
    }

    @Override
    public List<RestaurantDomainEntity> findRestaurants() {

        logger.info("Searching all restaurants");

        final var entities = restaurantRepository.findAll();

        return RestaurantMapper.toDomainEntity(entities);
    }

    @Override
    public RestaurantDomainEntity findByExternalId(
            final UUID externalId
    ) {

        logger.info("Searching restaurant by external id: {}", externalId);

        final var entity = restaurantRepository.findRestaurantsByExternalId(externalId);

        if (entity.isPresent()) {
            return RestaurantMapper.toDomainEntity(entity.get());
        } else {
            throw new RestaurantDomainCustomException("Restaurant not found");
        }
    }

    @PostConstruct
    public void init() {
        if (restaurantRepository.count() == 0) {

            for (final var restaurant : RestaurantsEnum.values()) {

                RestaurantDomainEntity restaurantDomainEntity = new RestaurantDomainEntity(
                        UUID.fromString(restaurant.getExternalId()),
                        restaurant.getName().toLowerCase(Locale.ROOT),
                        restaurant.getLocation().toLowerCase(Locale.ROOT),
                        restaurant.getCuisineType().toString().toLowerCase(Locale.ROOT),
                        8.0,
                        restaurant.getCapacity(),
                        LocalDateTime.now()
                );
                restaurantRepository.save(RestaurantMapper.toEntity(restaurantDomainEntity));
            }

        }
    }
}
