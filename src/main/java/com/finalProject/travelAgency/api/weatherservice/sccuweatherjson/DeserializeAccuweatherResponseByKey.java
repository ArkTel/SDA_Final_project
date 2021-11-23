package com.finalProject.travelAgency.api.weatherservice.sccuweatherjson;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalProject.travelAgency.api.weatherservice.AccuResponse.AccuweatherResponseByKey;

public class DeserializeAccuweatherResponseByKey {

    public AccuweatherResponseByKey deserializeAccuweatherResponseByKey(String accuweatherJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AccuweatherResponseByKey accuweatherResponseByKey = objectMapper.readValue(accuweatherJson, AccuweatherResponseByKey.class);
        return accuweatherResponseByKey;
    }
}
