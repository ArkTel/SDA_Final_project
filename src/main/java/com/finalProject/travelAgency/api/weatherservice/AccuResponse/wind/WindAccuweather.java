package com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind.winddirection.WindDirectionAccuweather;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.wind.windspeed.WindSpeedAccuweather;

public class WindAccuweather {
    private WindSpeedAccuweather Speed;
    private WindDirectionAccuweather Direction;

    public void setSpeed(WindSpeedAccuweather speed) {
        Speed = speed;
    }

    public void setDirection(WindDirectionAccuweather direction) {
        Direction = direction;
    }

    @JsonGetter("Speed")
    public WindSpeedAccuweather getSpeed() {
        return Speed;
    }

    @JsonGetter("Direction")
    public WindDirectionAccuweather getDirection() {
        return Direction;
    }

    @Override
    public String toString() {
        return "WindAccuweather{" +
                "Speed=" + Speed +
                ", Direction=" + Direction +
                '}';
    }
}
