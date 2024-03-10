package com.fiap.reservarest.adapter.restaurant.mapper;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;
import com.fiap.reservarest.application.shared.CustomResponse;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantSearchDomainEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RestaurantMapper {

    public static RestaurantDomainEntity toDomainEntity(
            final RestaurantEntity restaurantEntity
    ) {
        return new RestaurantDomainEntity(
                restaurantEntity.getId(),
                restaurantEntity.getExternalId(),
                restaurantEntity.getName(),
                restaurantEntity.getLocation(),
                restaurantEntity.getCuisineType(),
                restaurantEntity.getHoursOfOperation(),
                restaurantEntity.getCapacity(),
                restaurantEntity.getCreateAt()
        );
    }

    public static List<RestaurantDomainEntity> toDomainEntity(
            final List<RestaurantEntity> restaurantEntities
    ) {

        return restaurantEntities.stream()
                .map(restaurantEntity -> new RestaurantDomainEntity(
                        restaurantEntity.getExternalId(),
                        restaurantEntity.getName(),
                        restaurantEntity.getLocation(),
                        restaurantEntity.getCuisineType(),
                        restaurantEntity.getHoursOfOperation(),
                        restaurantEntity.getCapacity(),
                        restaurantEntity.getCreateAt()
                ))
                .toList();
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
                restaurantDomainEntity.getId(),
                restaurantDomainEntity.getExternalId(),
                restaurantDomainEntity.getName(),
                restaurantDomainEntity.getLocation(),
                restaurantDomainEntity.getCuisineType(),
                restaurantDomainEntity.getHoursOfOperation(),
                restaurantDomainEntity.getCapacity(),
                restaurantDomainEntity.getCreateAt()
        );
    }

    public static RestaurantSearchDomainEntity toDomainEntity(
            final String keyword
    ) {
        return new RestaurantSearchDomainEntity(
                keyword
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

    public static CustomResponse<List<RestaurantResponseDTO>> toResponseDTO(
            final List<RestaurantDomainEntity> restaurantDomainEntities
    ) {
        final var response = restaurantDomainEntities.stream().map(restaurantDomainEntity -> new RestaurantResponseDTO(
                restaurantDomainEntity.getExternalId(),
                restaurantDomainEntity.getName(),
                restaurantDomainEntity.getLocation(),
                restaurantDomainEntity.getCuisineType(),
                restaurantDomainEntity.getHoursOfOperation(),
                restaurantDomainEntity.getCapacity(),
                restaurantDomainEntity.getCreateAt()
        )).toList();

        return new CustomResponse<List<RestaurantResponseDTO>>().setData(response);
    }

    public static RestaurantResponseDTO toResponse(
            final RestaurantDomainEntity restaurantDomainEntity
    ) {
        return new RestaurantResponseDTO(
                restaurantDomainEntity.getExternalId(),
                restaurantDomainEntity.getName(),
                restaurantDomainEntity.getLocation(),
                restaurantDomainEntity.getCuisineType(),
                restaurantDomainEntity.getHoursOfOperation(),
                restaurantDomainEntity.getCapacity(),
                restaurantDomainEntity.getCreateAt()
        );

    }

}
