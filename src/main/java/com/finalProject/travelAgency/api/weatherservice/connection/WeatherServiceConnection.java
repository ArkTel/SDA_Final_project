package com.finalProject.travelAgency.api.weatherservice.connection;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherServiceConnection {
    private String apkey = "iLMHejPpxQb8aAHiKEisjROm5rjq7uNu";
    private final String BASE_URL = "http://dataservice.accuweather.com/locations/v1/search?q=";
    private final String BASE_URL_BY_CITY_KEY ="http://dataservice.accuweather.com/currentconditions/v1/";
    private String url;
    private String urlByCityKey;

    public void  createBaseUrl( String cityName) {
        url=BASE_URL + cityName+"&apikey="+apkey;
    }

    public Response getResponseFromAcuweather() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        Response response = call.execute();
        return  response;
    }

    public void createUrlByCityKey(String cityKey){
        urlByCityKey = BASE_URL_BY_CITY_KEY+cityKey+"?apikey="+apkey+"&details=true";
    }

    public Response getResponseByCityKeyFromAcuweather() throws IOException {
        Request request = new Request.Builder()
                .url(urlByCityKey)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        Response response = call.execute();
        return  response;
    }
}


