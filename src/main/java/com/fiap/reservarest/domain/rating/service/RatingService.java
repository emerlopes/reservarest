package com.fiap.reservarest.domain.rating.service;

import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;

import java.util.List;

public interface RatingService {

    RatingDomainEntity createRating(RatingDomainEntity ratingDomainEntity);

    List<RatingDomainEntity> findRatings();
}
