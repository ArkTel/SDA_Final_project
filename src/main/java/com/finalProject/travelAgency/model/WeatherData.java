package com.finalProject.travelAgency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class WeatherData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;

    @Column(name = "atmospheric_pressure")
    private double atmosphericPresure;

    private double humidity;

    @Column(name = "wind_direction")
    private double windDirection;

    @Column (name = "wind_speed")
    private double windSpeed;

    @Column (name = "localisation_name")
    private String  localisationName;
}
