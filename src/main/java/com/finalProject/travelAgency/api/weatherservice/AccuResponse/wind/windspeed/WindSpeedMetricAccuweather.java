package com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind.windspeed;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindSpeedMetricAccuweather {
    private double Value;


    public void setValue(double value) {
        this.Value = value;
    }

    @JsonGetter("Value")
    public double getValue() {
        return Value;
    }

    @Override
    public String toString() {
        return "WindSpeedMetricAccuweather{" +
                "Value=" + Value +
                '}';
    }
}
