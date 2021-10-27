package com.finalProject.travelAgency.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valueFrom")
    private String from;
    @Column(name = "valueTo")
    private String to;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private String offersType;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private boolean isPromoted;
    private int availablePlacesForAdult;
    private int availablePlacesForChildren;

    public Tour(Long id, String from, String to, LocalDateTime arrivalDate, LocalDateTime departureDate, String offersType, BigDecimal priceForAdult, BigDecimal priceForChild, boolean isPromoted, int availablePlacesForAdult, int availablePlacesForChildren) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.offersType = offersType;
        this.priceForAdult = priceForAdult;
        this.priceForChild = priceForChild;
        this.isPromoted = isPromoted;
        this.availablePlacesForAdult = availablePlacesForAdult;
        this.availablePlacesForChildren = availablePlacesForChildren;
    }


    public Tour() {

    }

}
