package com.finalProject.travelAgency.api.weatherservice.sccuweatherjson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.AccuweatherResponse;

public class DeserializeAccuweatherResponse {

    public AccuweatherResponse deserializeAccuweatherResponse(String accuweatherJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AccuweatherResponse accuweatherResponse = objectMapper.readValue(accuweatherJson, AccuweatherResponse.class);;
        return accuweatherResponse;
    }
}
