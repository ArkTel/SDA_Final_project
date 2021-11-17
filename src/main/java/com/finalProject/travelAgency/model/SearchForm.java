package com.finalProject.travelAgency.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SearchForm {
    private String city;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

}
