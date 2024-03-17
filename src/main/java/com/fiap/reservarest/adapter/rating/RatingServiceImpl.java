package com.fiap.reservarest.adapter.rating;

import com.fiap.reservarest.adapter.rating.mapper.RatingMapper;
import com.fiap.reservarest.adapter.rating.repository.RatingRepository;
import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;
import com.fiap.reservarest.domain.rating.service.RatingService;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final Logger logger;

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(
            final Logger logger,
            final RatingRepository ratingRepository
    ) {
        this.logger = logger;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingDomainEntity createRating(
            final RatingDomainEntity ratingDomainEntity
    ) {
        logger.info("Creating rating: {}", ratingDomainEntity.getRating());

        final var ratingEntity = RatingMapper.toEntity(ratingDomainEntity);
        final var entitySaved = ratingRepository.save(ratingEntity);

        logger.info("Rating created: {}", entitySaved.getRatingId());

        return RatingMapper.toDomainEntity(entitySaved);
    }

    @Override
    public List<RatingDomainEntity> findRatings() {

        logger.info("Finding ratings");

        final var enetities = ratingRepository.findAll();

        logger.info("Ratings found: {}", enetities.size());

        return RatingMapper.toDomainEntity(enetities);
    }

    @PostConstruct
    public void init() {
        logger.info("RatingServiceImpl started");

        if (ratingRepository.count() == 0) {
            logger.info("Creating default ratings");
            final var rating1 = new RatingDomainEntity(
                    UUID.randomUUID(),
                    5,
                    "Excellent restaurant",
                    LocalDateTime.now().minusDays(1)

            );

            final var rating2 = new RatingDomainEntity(
                    UUID.randomUUID(),
                    4,
                    "Good restaurant",
                    LocalDateTime.now().minusDays(2)
            );

            final var rating3 = new RatingDomainEntity(
                    UUID.randomUUID(),
                    3,
                    "Regular restaurant",
                    LocalDateTime.now().minusDays(3)
            );

            final var rating4 = new RatingDomainEntity(
                    UUID.randomUUID(),
                    2,
                    "Bad restaurant",
                    LocalDateTime.now().minusDays(4)
            );

            final var ratings = List.of(rating1, rating2, rating3, rating4);

            ratingRepository.saveAll(RatingMapper.toEntities(ratings));

        }
    }
}
