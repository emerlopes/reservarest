package com.fiap.reservarest.bdd.dto;

import com.fiap.reservarest.application.entrypoint.rest.restaurant.dto.RestaurantResponseDTO;

public class CustomResponseRestaurantDTO {
    private RestaurantResponseTestDTO data;

    public RestaurantResponseTestDTO getData() {
        return data;
    }

    public void setData(RestaurantResponseTestDTO data) {
        this.data = data;
    }
}
