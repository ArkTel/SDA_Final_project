package com.finalProject.travelAgency.model;

import javax.persistence.*;

@Entity(name = "tour_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User userId;
    @ManyToOne
    @JoinColumn(name = "id",insertable = false, updatable = false)
    private Tour tourId;
    private int orderPlacesForAdults;
    private int orderPlacesForChildren;
    private int totalPrice;

    public Order(Long id, User userId, Tour tourId, int orderPlacesForAdults, int orderPlacesForChildren, int totalPrice) {
        this.id = id;
        this.userId = userId;
        this.tourId = tourId;
        this.orderPlacesForAdults = orderPlacesForAdults;
        this.orderPlacesForChildren = orderPlacesForChildren;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }
}
