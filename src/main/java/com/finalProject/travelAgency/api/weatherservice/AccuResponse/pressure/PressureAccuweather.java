package com.finalProject.travelAgency.api.weatherservice.AccuResponse.pressure;

import com.fasterxml.jackson.annotation.JsonGetter;

public class PressureAccuweather {
    private MetricPressureAccuweather Metric;

    public void setMetric(MetricPressureAccuweather metric) {
        Metric = metric;
    }

    @JsonGetter("Metric")
    public MetricPressureAccuweather getMetric() {
        return Metric;
    }

    @Override
    public String toString() {
        return "PressureAccuweather{" +
                "Metric=" + Metric +
                '}';
    }
}
