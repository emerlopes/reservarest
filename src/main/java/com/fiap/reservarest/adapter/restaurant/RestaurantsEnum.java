package com.fiap.reservarest.adapter.restaurant;

import java.util.UUID;

public enum RestaurantsEnum {

    RESTAURANTE_A("6ed285bb-f2f6-4bfa-a1bf-837ebd8019f5", "Restaurante da Nonna", CuisineTypeEnum.ITALIANA, "Rua das Flores, 123", "08:00 - 22:00", 50),
    RESTAURANTE_B("552093ec-7887-4dff-a706-becf408defab", "Sushi Express", CuisineTypeEnum.JAPONESA, "Avenida Central, 456", "11:00 - 23:00", 40),
    RESTAURANTE_C("10a4dc3b-b775-4dc9-82d5-ba54398cced6", "Taquería del Sol", CuisineTypeEnum.MEXICANA, "Rua dos Tacos, 789", "10:00 - 21:00", 60),
    RESTAURANTE_D("efb7230d-4b4c-4c20-9a3d-87d248820562", "Burger Haven", CuisineTypeEnum.FAST_FOOD, "Rua das Hamburguerias, 101", "09:00 - 00:00", 30),
    RESTAURANTE_E("48d87425-79b4-436e-9eb6-9c2e3b96c855", "Taj Mahal", CuisineTypeEnum.INDIANA, "Avenida das Especiarias, 210", "12:00 - 23:00", 70),
    RESTAURANTE_F("09e849a2-c62b-4dfe-837c-0283588a1e01", "Comida da vóvó", CuisineTypeEnum.BRASILEIRA, "Rua dos Sabores, 15", "07:00 - 20:00", 20);

    private final String externalId;
    private final String name;
    private final CuisineTypeEnum cuisineType;
    private final String location;
    private final String hoursOfOperation;
    private final int capacity;

    RestaurantsEnum(
            final String externalId,
            final String name,
            final CuisineTypeEnum cuisineType,
            final String location,
            final String hoursOfOperation,
            final int capacity
    ) {
        this.externalId = externalId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.location = location;
        this.hoursOfOperation = hoursOfOperation;
        this.capacity = capacity;
    }


    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public CuisineTypeEnum getCuisineType() {
        return cuisineType;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }
}
