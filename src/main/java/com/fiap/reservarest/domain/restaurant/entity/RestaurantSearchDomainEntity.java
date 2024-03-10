package com.fiap.reservarest.domain.restaurant.entity;

import java.util.Locale;

public class RestaurantSearchDomainEntity {
    private String keyWord;

    public RestaurantSearchDomainEntity(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }

}
