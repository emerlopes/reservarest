package com.fiap.reservarest.application.bean;

import com.fiap.reservarest.domain.booking.service.BookingService;
import com.fiap.reservarest.domain.booking.usecase.BookingUseCase;
import com.fiap.reservarest.domain.booking.usecase.impl.BookingUseCaseImpl;
import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantSearchUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.impl.RestaurantCreationUseCaseImpl;
import com.fiap.reservarest.domain.restaurant.usecase.impl.RestaurantSearchUseCaseImpl;
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
}
