package com.fiap.reservarest.application.bean;

import com.fiap.reservarest.domain.reservation.service.ReservationService;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByIdUseCase;
import com.fiap.reservarest.domain.reservation.usecase.ReservationSearchByRestaurantUseCase;
import com.fiap.reservarest.domain.reservation.usecase.ReservationUseCase;
import com.fiap.reservarest.domain.reservation.usecase.UpdateReservationUseCase;
import com.fiap.reservarest.domain.reservation.usecase.impl.ReservationSearchByIdUseCaseImpl;
import com.fiap.reservarest.domain.reservation.usecase.impl.ReservationSearchByRestaurantUseCaseImpl;
import com.fiap.reservarest.domain.reservation.usecase.impl.ReservationUseCaseImpl;
import com.fiap.reservarest.domain.rating.service.RatingService;
import com.fiap.reservarest.domain.rating.usecase.RatingCreationUseCase;
import com.fiap.reservarest.domain.rating.usecase.impl.RatingCreationUseCaseImpl;
import com.fiap.reservarest.domain.reservation.usecase.impl.UpdateReservationUseCaseImpl;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantSearchUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.impl.RestaurantCreationUseCaseImpl;
import com.fiap.reservarest.domain.restaurant.usecase.impl.RestaurantSearchUseCaseImpl;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public RestaurantCreationUseCase restaurantCreationUseCaseInstance(
            final RestaurantService restaurantService
    ) {
        return new RestaurantCreationUseCaseImpl(restaurantService);
    }

    @Bean
    public RestaurantSearchUseCase restaurantSearchUseCaseInstance(
            final RestaurantService restaurantService
    ) {
        return new RestaurantSearchUseCaseImpl(restaurantService);
    }

    @Bean
    public ReservationUseCase bookingUseCaseInstance(
            final ReservationService reservationService,
            final RestaurantService restaurantService
    ) {
        return new ReservationUseCaseImpl(reservationService, restaurantService);
    }

    @Bean
    public RatingCreationUseCase ratingCreationUseCaseInstance(
            final RatingService ratingService
    ) {
        return new RatingCreationUseCaseImpl(ratingService);
    }

    @Bean
    public ReservationSearchByRestaurantUseCase reservationSearchByRestaurantUseCaseInstance(
            final ReservationService reservationService,
            final RestaurantService restaurantService
    ) {
        return new ReservationSearchByRestaurantUseCaseImpl(reservationService, restaurantService);
    }

    @Bean
    public ReservationSearchByIdUseCase reservationSearchByIdUseCaseInstance(
            final ReservationService reservationService
    ) {
        return new ReservationSearchByIdUseCaseImpl(reservationService);
    }

    @Bean
    public UpdateReservationUseCase updateReservationUseCaseInstance(
            final ReservationService reservationService
    ) {
        return new UpdateReservationUseCaseImpl(reservationService);
    }

    @Bean
    public Logger loggerInstance() {
        return org.apache.logging.log4j.LogManager.getLogger();
    }
}
