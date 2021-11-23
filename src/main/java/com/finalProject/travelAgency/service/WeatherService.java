package com.finalProject.travelAgency.service;


import com.finalProject.travelAgency.api.weatherservice.AccuResponse.AccuweatherResponse;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.AccuweatherResponseByKey;
import com.finalProject.travelAgency.api.weatherservice.connection.WeatherServiceConnection;
import com.finalProject.travelAgency.api.weatherservice.sccuweatherjson.DeserializeAccuweatherResponse;
import com.finalProject.travelAgency.api.weatherservice.sccuweatherjson.DeserializeAccuweatherResponseByKey;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    public AccuweatherResponseByKey getResultFromAccuweather(String cityName) throws IOException {
        WeatherServiceConnection accuweatherService = new WeatherServiceConnection();

        accuweatherService.createBaseUrl(cityName);
        Response accuweatherResponseForCityKey = accuweatherService.getResponseFromAcuweather();
        DeserializeAccuweatherResponse deserializeAccuweatherResponse = new DeserializeAccuweatherResponse();
        String accuweatherJason = (accuweatherResponseForCityKey.body().string());
        String newAccuweatherJason = (accuweatherJason.substring(1, accuweatherJason.length() - 1));
        AccuweatherResponse cityKey = deserializeAccuweatherResponse.deserializeAccuweatherResponse(newAccuweatherJason);
        accuweatherService.createUrlByCityKey(cityKey.getKey());
        Response accuweatherResponseByCityKey = accuweatherService.getResponseByCityKeyFromAcuweather();
        String accuweatherJasonByKey = (accuweatherResponseByCityKey.body().string());
        String newAccuweatherJasonByKey = accuweatherJasonByKey.substring(1, accuweatherJasonByKey.length() - 1);
        DeserializeAccuweatherResponseByKey deserializedAccuweatherResponseByKey = new DeserializeAccuweatherResponseByKey();
        AccuweatherResponseByKey accuweatherResponseByKey = deserializedAccuweatherResponseByKey.deserializeAccuweatherResponseByKey(newAccuweatherJasonByKey);

        return accuweatherResponseByKey;
    }
}
