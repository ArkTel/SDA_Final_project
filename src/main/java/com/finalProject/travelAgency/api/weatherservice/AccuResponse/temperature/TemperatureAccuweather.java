package com.finalProject.travelAgency.api.weatherservice.AccuResponse.temperature;

import com.fasterxml.jackson.annotation.JsonGetter;

public class TemperatureAccuweather {
    private MetricAccuweather Metric;

    public void setMetric(MetricAccuweather metric) {
        Metric = metric;
    }

    @JsonGetter("Metric")
    public MetricAccuweather getMetric() {
        return Metric;
    }


    @Override
    public String toString() {
        return "TemperatureAccuweather{" +
                "Metric=" + Metric +
                '}';
    }
}
