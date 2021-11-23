package com.finalProject.travelAgency.api.weatherservice.AccuResponse;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.pressure.PressureAccuweather;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.temperature.TemperatureAccuweather;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind.WindAccuweather;

public class AccuweatherResponseByKey {

     TemperatureAccuweather Temperature;
     Integer RelativeHumidity;
     WindAccuweather Wind;
     PressureAccuweather Pressure;


    public void setPressure(PressureAccuweather pressure) {
        Pressure = pressure;
    }

    public void setRelativeHumidity(Integer relativeHumidity) {
        RelativeHumidity = relativeHumidity;
    }

    public void setTemperature(TemperatureAccuweather temperature) {
        Temperature = temperature;

    }

    public void setWind(WindAccuweather wind) {
        Wind = wind;
    }

    @JsonGetter("Pressure")
    public PressureAccuweather getPressure() {
        return Pressure;
    }

    @JsonGetter("Temperature")
    public TemperatureAccuweather getTemperature() {
        return Temperature;
    }

    @JsonGetter("RelativeHumidity")
    public Integer getRelativeHumidity() {
        return RelativeHumidity;
    }

    @JsonGetter("Wind")
    public WindAccuweather getWind() {
        return Wind;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKey{" +
                "Temperature=" + Temperature +
                ", RelativeHumidity=" + RelativeHumidity +
                ", Wind=" + Wind +
                ", Pressure=" + Pressure +
                '}';
    }
}
