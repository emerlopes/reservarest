package com.fiap.reservarest.adapter.rating;

import com.fiap.reservarest.adapter.rating.entity.RatingEntity;
import com.fiap.reservarest.adapter.rating.repository.RatingRepository;
import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RatingServiceImplTest {

    @Mock
    private Logger logger;

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingServiceImpl ratingService;

    @Test
    public void shouldCreateRating() {
        // Arrange
        RatingDomainEntity ratingDomainEntity = new RatingDomainEntity(
                UUID.randomUUID(),
                5,
                "Great service!",
                LocalDateTime.now()
        );

        RatingEntity ratingEntity = new RatingEntity(
                ratingDomainEntity.getRestaurantId(),
                ratingDomainEntity.getRating(),
                ratingDomainEntity.getComment(),
                ratingDomainEntity.getCreatedAt()
        );

        when(ratingRepository.save(any())).thenReturn(ratingEntity);

        // Act
        RatingDomainEntity result = ratingService.createRating(ratingDomainEntity);

        // Assert
        assertNotNull(result);
        verify(logger).info("Creating rating: {}", ratingDomainEntity.getRating());
        verify(logger).info("Rating created: {}", result.getRatingId());
        verify(ratingRepository).save(any());
    }

    @Test
    public void shouldFindRatings() {
        // Arrange
        List<RatingDomainEntity> mockEntities = new ArrayList<>();
        mockEntities.add(new RatingDomainEntity(
                UUID.randomUUID(),
                5,
                "Great service!",
                LocalDateTime.now()
        ));
        mockEntities.add(new RatingDomainEntity(
                UUID.randomUUID(),
                5,
                "Great service!",
                LocalDateTime.now()
        ));

        List<RatingEntity> ratingEntities = new ArrayList<>();
        ratingEntities.add(new RatingEntity(
                mockEntities.get(0).getRestaurantId(),
                mockEntities.get(0).getRating(),
                mockEntities.get(0).getComment(),
                mockEntities.get(0).getCreatedAt()
        ));

        ratingEntities.add(new RatingEntity(
                mockEntities.get(1).getRestaurantId(),
                mockEntities.get(1).getRating(),
                mockEntities.get(1).getComment(),
                mockEntities.get(1).getCreatedAt()
        ));

        when(ratingRepository.findAll()).thenReturn(ratingEntities);

        // Act
        List<RatingDomainEntity> result = ratingService.findRatings();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(logger).info("Finding ratings");
        verify(logger).info("Ratings found: {}", 2);
        verify(ratingRepository).findAll();
    }

}