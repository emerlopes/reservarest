package com.fiap.reservarest.domain.rating.usecase.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;
import com.fiap.reservarest.domain.rating.service.RatingService;

import java.time.LocalDateTime;
import java.util.UUID;

public class RatingCreationUseCaseImplTest {

    private RatingService ratingService;
    private RatingCreationUseCaseImpl ratingCreationUseCase;

    @BeforeEach
    public void setUp() {
        ratingService = mock(RatingService.class);
        ratingCreationUseCase = new RatingCreationUseCaseImpl(ratingService);
    }

    @Test
    public void shouldCreateRating() {
        // Arrange
        RatingDomainEntity ratingDomainEntity = new RatingDomainEntity(
                UUID.randomUUID(),
                5,
                "Great service!",
                LocalDateTime.now()

        );
        when(ratingService.createRating(ratingDomainEntity)).thenReturn(ratingDomainEntity);

        // Act
        RatingDomainEntity result = ratingCreationUseCase.execute(ratingDomainEntity);

        // Assert
        assertNotNull(result);
        verify(ratingService, times(1)).createRating(ratingDomainEntity);
    }
}
