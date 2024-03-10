package com.fiap.reservarest.adapter.booking.entity;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private String reservationName;
    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "id")
    private RestaurantEntity restaurantEntity;

    private Integer amountPeople;

    public BookingEntity(
            final String reservationName,
            final LocalDateTime reservationTime,
            final RestaurantEntity restaurantEntity,
            final Integer amountPeople
    ) {
        this.reservationName = reservationName;
        this.reservationTime = reservationTime;
        this.restaurantEntity = restaurantEntity;
        this.amountPeople = amountPeople;
    }
}
