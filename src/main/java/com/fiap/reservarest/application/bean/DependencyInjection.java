package com.fiap.reservarest.application.bean;

import com.fiap.reservarest.domain.restaurant.service.RestaurantService;
import com.fiap.reservarest.domain.restaurant.usecase.RestaurantCreationUseCase;
import com.fiap.reservarest.domain.restaurant.usecase.impl.RestaurantCreationUseCaseImpl;
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
}
