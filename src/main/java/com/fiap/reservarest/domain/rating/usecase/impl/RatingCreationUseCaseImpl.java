package com.fiap.reservarest.domain.rating.usecase.impl;

import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;
import com.fiap.reservarest.domain.rating.service.RatingService;
import com.fiap.reservarest.domain.rating.usecase.RatingCreationUseCase;

public class RatingCreationUseCaseImpl implements RatingCreationUseCase {

    private final RatingService ratingService;

    public RatingCreationUseCaseImpl(
            final RatingService ratingService
    ) {
        this.ratingService = ratingService;
    }

    @Override
    public RatingDomainEntity execute(
            final RatingDomainEntity ratingDomainEntity
    ) {
        return ratingService.createRating(ratingDomainEntity);
    }
}
