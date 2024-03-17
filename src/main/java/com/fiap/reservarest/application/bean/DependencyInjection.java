package com.fiap.reservarest.application.bean;

import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.booking.usecase.BookingUseCase;
import com.fiap.reservarest.domain.booking.usecase.impl.BookingUseCaseImpl;
import com.fiap.reservarest.domain.rating.service.RatingService;
import com.fiap.reservarest.domain.rating.usecase.RatingCreationUseCase;
import com.fiap.reservarest.domain.rating.usecase.impl.RatingCreationUseCaseImpl;
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
    public BookingUseCase bookingUseCaseInstance(
            final BookingService bookingService,
            final RestaurantService restaurantService
    ) {
        return new BookingUseCaseImpl(bookingService, restaurantService);
    }

    @Bean
    public RatingCreationUseCase ratingCreationUseCaseInstance(
            final RatingService ratingService
    ) {
        return new RatingCreationUseCaseImpl(ratingService);
    }

    @Bean
    public Logger loggerInstance() {
        return org.apache.logging.log4j.LogManager.getLogger();
    }
}
