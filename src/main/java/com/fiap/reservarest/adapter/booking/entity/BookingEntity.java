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
    private String reservationEmail;
    private String reservationPhone;
    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private RestaurantEntity restaurantEntity;

    private Integer amountPeople;

    private BookingStatusEnum status;

    public BookingEntity(
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final RestaurantEntity restaurantEntity,
            final Integer amountPeople,
            final BookingStatusEnum status
    ) {
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.restaurantEntity = restaurantEntity;
        this.amountPeople = amountPeople;
        this.status = status;
    }
}
