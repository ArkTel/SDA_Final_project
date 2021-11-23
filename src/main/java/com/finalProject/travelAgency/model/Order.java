package com.finalProject.travelAgency.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "tour_orders")
@Getter
@Setter
@ToString
@Builder
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
    private BigDecimal totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
