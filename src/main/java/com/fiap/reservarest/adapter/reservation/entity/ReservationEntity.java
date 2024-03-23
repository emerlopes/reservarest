package com.fiap.reservarest.adapter.reservation.entity;

import com.fiap.reservarest.adapter.restaurant.entity.RestaurantEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class ReservationEntity {

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

    private ReservationStatusEnum status;

    public ReservationEntity(
            final String reservationName,
            final String reservationEmail,
            final String reservationPhone,
            final LocalDateTime reservationTime,
            final RestaurantEntity restaurantEntity,
            final Integer amountPeople,
            final ReservationStatusEnum status
    ) {
        this.reservationName = reservationName;
        this.reservationEmail = reservationEmail;
        this.reservationPhone = reservationPhone;
        this.reservationTime = reservationTime;
        this.restaurantEntity = restaurantEntity;
        this.amountPeople = amountPeople;
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "reservation_id:" + reservationId +
                ", reservation_name:'" + reservationName + '\'' +
                ", reservation_email:'" + reservationEmail + '\'' +
                ", reservation_phone:'" + reservationPhone + '\'' +
                ", reservation_time:" + reservationTime +
                ", restaurant_entity:" + restaurantEntity +
                ", amount_people:" + amountPeople +
                ", status:" + status +
                '}';
    }
}
