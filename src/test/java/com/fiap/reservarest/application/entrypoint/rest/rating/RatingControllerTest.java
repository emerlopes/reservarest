package com.fiap.reservarest.application.entrypoint.rest.rating;

import com.fiap.reservarest.application.entrypoint.rest.rating.dto.RatingRequestDTO;
import com.fiap.reservarest.application.entrypoint.rest.rating.dto.RatingResponseDTO;
import com.fiap.reservarest.domain.rating.entity.RatingDomainEntity;
import com.fiap.reservarest.domain.rating.usecase.RatingCreationUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RatingControllerTest {

    @Test
    public void shouldCreateRating() {
        // Arrange
        RatingRequestDTO request = new RatingRequestDTO();
        RatingDomainEntity ratingDomainEntity = new RatingDomainEntity(
                1L,
                null,
                5,
                "Great!",
                null
        );
        RatingResponseDTO responseDTO = new RatingResponseDTO(
                1L,
                null,
                5,
                "Great!",
                null
        );

        RatingCreationUseCase ratingCreationUseCase = mock(RatingCreationUseCase.class);
        when(ratingCreationUseCase.execute(any())).thenReturn(ratingDomainEntity);
        RatingController ratingController = new RatingController(ratingCreationUseCase);

        // Act
        final var responseEntity = ratingController.createRating(request);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof RatingResponseDTO);
        verify(ratingCreationUseCase, times(1)).execute(any());
    }

}