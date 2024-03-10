package com.fiap.reservarest.adapter.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id")
    private UUID externalId;
    private String name;
    private String location;

    @Column(name = "cuisine_type")
    private String cuisineType;

    @Column(name = "hours_of_operation")
    private Double hoursOfOperation;

    private Integer capacity;
    private LocalDateTime createAt;

    public RestaurantEntity(
            final UUID externalId,
            final String name,
            final String location,
            final String cuisineType,
            final Double hoursOfOperation,
            final Integer capacity,
            final LocalDateTime createAt
    ) {
        this.externalId = externalId;
        this.name = name.toLowerCase(Locale.ROOT);
        this.location = location.toLowerCase();
        this.cuisineType = cuisineType.toLowerCase(Locale.ROOT);
        this.hoursOfOperation = hoursOfOperation;
        this.capacity = capacity;
        this.createAt = createAt;
    }

}
