package com.finalProject.travelAgency.api.weatherservice.AccuResponse;

import com.fasterxml.jackson.annotation.JsonGetter;

public class AccuweatherResponse {
    private String Key;

    public void setKey(String Key){this.Key=Key;}

    @JsonGetter("Key")
    public String getKey(){return Key;}

    @Override
    public String toString() {
        return "AccuweatherResponse{" +
                "cityKey='" + Key + '\'' +
                '}';
    }
}
