package com.finalProject.travelAgency.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderForm {

    private int orderPlacesForAdults;
    private int orderPlacesForChildren;
    private long tourId;
    private BigDecimal sum;


//    private Long tourId

}
