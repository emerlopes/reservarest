package com.fiap.reservarest.domain.restaurant.entity;


public class RestaurantSearchDomainEntity {
    private String keyWord;

    public RestaurantSearchDomainEntity(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }

}
