package com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind.winddirection;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindDirectionAccuweather {

    private double Degrees;

    public void setDegrees(double degrees) {
        Degrees = degrees;
    }

    @JsonGetter("Degrees")
    public double getDegrees() {
        return Degrees;
    }

    @Override
    public String toString() {
        return "WindDirectionAccuweather{" +
                "Degrees=" + Degrees +
                '}';
    }
}
