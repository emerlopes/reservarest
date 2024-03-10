package com.fiap.reservarest.adapter.restaurant.mapper;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class RestaurantMapper {

    public static RestaurantDomainEntity toDomainEntity(
            final RestaurantEntity restaurantEntity
    ) {
        return new RestaurantDomainEntity(
                restaurantEntity.getExternalId(),
                restaurantEntity.getName(),
                restaurantEntity.getLocation(),
                restaurantEntity.getCuisineType(),
                restaurantEntity.getHoursOfOperation(),
                restaurantEntity.getCapacity(),
                restaurantEntity.getCreateAt()
        );
    }

    public static RestaurantDomainEntity toDomainEntity(
            final RestaurantRequestDTO restaurantRequestDTO
    ) {
        return new RestaurantDomainEntity(
                UUID.randomUUID(),
                restaurantRequestDTO.name(),
                restaurantRequestDTO.location(),
                restaurantRequestDTO.cuisineType(),
                restaurantRequestDTO.hoursOfOperation(),
                restaurantRequestDTO.capacity(),
                LocalDateTime.now()
        );
    }

    public static RestaurantEntity toEntity(
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        return new RestaurantEntity(
                restaurantDomainEntity.getExternalId(),
                restaurantDomainEntity.getName(),
                restaurantDomainEntity.getLocation(),
                restaurantDomainEntity.getCuisineType(),
                restaurantDomainEntity.getHoursOfOperation(),
                restaurantDomainEntity.getCapacity(),
                restaurantDomainEntity.getCreateAt()
        );
    }

    public static CustomResponse<RestaurantResponseDTO> toResponseDTO(
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        final var response = new RestaurantResponseDTO(
                restaurantDomainEntity.getExternalId(),
                restaurantDomainEntity.getName(),
                restaurantDomainEntity.getLocation(),
                restaurantDomainEntity.getCuisineType(),
                restaurantDomainEntity.getHoursOfOperation(),
                restaurantDomainEntity.getCapacity(),
                restaurantDomainEntity.getCreateAt()
        );

        return new CustomResponse<RestaurantResponseDTO>().setData(response);
    }
}
