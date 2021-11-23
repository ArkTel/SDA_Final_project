package com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind.windspeed;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindSpeedAccuweather {

    private WindSpeedMetricAccuweather Metric;

    public void setMetric(WindSpeedMetricAccuweather metric) {
        Metric = metric;
    }

    @JsonGetter("Metric")
    public WindSpeedMetricAccuweather getMetric() {
        return Metric;
    }

    @Override
    public String toString() {
        return "WindSpeedAccuweather{" +
                "Metric=" + Metric +
                '}';
    }
}
