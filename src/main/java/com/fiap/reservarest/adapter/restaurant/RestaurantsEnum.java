package com.fiap.reservarest.adapter.restaurant;

public enum RestaurantsEnum {

    RESTAURANTE_A("Restaurante da Nonna", CuisineTypeEnum.ITALIANA, "Rua das Flores, 123", "08:00 - 22:00", 50),
    RESTAURANTE_B("Sushi Express", CuisineTypeEnum.JAPONESA, "Avenida Central, 456", "11:00 - 23:00", 40),
    RESTAURANTE_C("Taquería del Sol", CuisineTypeEnum.MEXICANA, "Rua dos Tacos, 789", "10:00 - 21:00", 60),
    RESTAURANTE_D("Burger Haven", CuisineTypeEnum.FAST_FOOD, "Rua das Hamburguerias, 101", "09:00 - 00:00", 30),
    RESTAURANTE_E("Taj Mahal", CuisineTypeEnum.INDIANA, "Avenida das Especiarias, 210", "12:00 - 23:00", 70),
    RESTAURANTE_F("Comida da vóvó", CuisineTypeEnum.BRASILEIRA, "Rua dos Sabores, 15", "07:00 - 20:00", 20);

    private final String name;
    private final CuisineTypeEnum cuisineType;
    private final String location;
    private final String hoursOfOperation;
    private final int capacity;

    RestaurantsEnum(String name, CuisineTypeEnum cuisineType, String location, String hoursOfOperation, int capacity) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.location = location;
        this.hoursOfOperation = hoursOfOperation;
        this.capacity = capacity;
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
