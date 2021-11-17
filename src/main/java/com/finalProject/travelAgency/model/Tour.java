package com.finalProject.travelAgency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;



@Data
@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "valueFrom")
    private String from;
    @Column(name = "valueTo")
    private String to;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;
    private String offersType;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private boolean isPromoted;
    private int availablePlacesForAdult;
    private int availablePlacesForChildren;
    private String tourDescription;
    private String imgLink;

    public Tour(Long id, String from, String to, LocalDate arrivalDate, LocalDate departureDate, String offersType, BigDecimal priceForAdult, BigDecimal priceForChild, boolean isPromoted, int availablePlacesForAdult, int availablePlacesForChildren, String tourDescription, String imgLink) {
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
        this.tourDescription = tourDescription;
        this.imgLink = imgLink;
    }

    public Tour() {

    }

    public boolean getIsPromoted() {
        return isPromoted;
    }

    public void setIsPromoted(boolean isPromoted) {
        this.isPromoted=isPromoted;
    }
}
