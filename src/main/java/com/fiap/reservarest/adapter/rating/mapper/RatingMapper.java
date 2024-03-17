package com.fiap.reservarest.adapter.rating.mapper;

import com.fiap.reservarest.adapter.rating.entity.RatingEntity;
import com.fiap.reservarest.application.entrypoint.rest.rating.dto.RatingRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.rating.dto.RatingResponseDTO;
import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;

import java.time.LocalDateTime;
import java.util.List;

public class RatingMapper {

    public static RatingDomainEntity toDomainEntity(
            final RatingRequestDTO ratingRequestDTO
    ) {
        return new RatingDomainEntity(
                ratingRequestDTO.getRestaurantId(),
                ratingRequestDTO.getRating(),
                ratingRequestDTO.getComment(),
                LocalDateTime.now()
        );
    }

    public static RatingResponseDTO toResponse(
            final RatingDomainEntity ratingDomainEntity
    ) {
        return new RatingResponseDTO(
                ratingDomainEntity.getRatingId(),
                ratingDomainEntity.getRestaurantId(),
                ratingDomainEntity.getRating(),
                ratingDomainEntity.getComment(),
                ratingDomainEntity.getCreatedAt()
        );
    }

    public static RatingDomainEntity toDomainEntity(
            final RatingEntity ratingEntity
    ) {
        return new RatingDomainEntity(
                ratingEntity.getRatingId(),
                ratingEntity.getRestaurantId(),
                ratingEntity.getRating(),
                ratingEntity.getComment(),
                ratingEntity.getCreatedAt()
        );
    }

    public static List<RatingDomainEntity> toDomainEntity(
            final List<RatingEntity> ratingEntities
    ) {
        return ratingEntities.stream()
                .map(RatingMapper::toDomainEntity)
                .toList();
    }

    public static RatingEntity toEntity(
            final RatingDomainEntity ratingDomainEntity
    ) {
        return new RatingEntity(
                ratingDomainEntity.getRestaurantId(),
                ratingDomainEntity.getRating(),
                ratingDomainEntity.getComment(),
                ratingDomainEntity.getCreatedAt()
        );
    }

    public static List<RatingEntity> toEntities(
            final List<RatingDomainEntity> ratingDomainEntities
    ) {
        return ratingDomainEntities.stream()
                .map(RatingMapper::toEntity)
                .toList();
    }
}
