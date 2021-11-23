package com.finalProject.travelAgency.api.weatherservice.AccuResponse.temperature;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MetricAccuweather {
    private double Value;

    public void setValue(double value) {
        Value = value;
    }
    @JsonGetter("Value")
    public double getValue() {
        return Value;
    }
    @Override
    public String toString() {
        return "MetricAccuweather{" +
                "Value=" + Value +
                '}';
    }
}
