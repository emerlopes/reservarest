package com.fiap.reservarest.domain.restaurant.usecase;

import com.fiap.reservarest.domain.restaurant.entity.RestaurantDomainEntity;
import com.fiap.reservarest.domain.restaurant.entity.RestaurantSearchDomainEntity;
import com.fiap.reservarest.domain.shared.ExecuteUseCase;

import java.util.List;

public interface RestaurantSearchUseCase extends ExecuteUseCase<List<RestaurantDomainEntity>, RestaurantSearchDomainEntity>{
}
