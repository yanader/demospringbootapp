package com.northcoders.demospringbootapp.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.model.LocationResults;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeocodingDAO {

    private final static String BASE_URL = "https://geocoding-api.open-meteo.com/v1/search";

    //https://geocoding-api.open-meteo.com/v1/search?name=Berlin&count=10&language=en
    public static LocationResults getData(String city) {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+"?name="+city))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            client.close();
//            System.out.println(response.body());
            return mapper.readValue(response.body(), LocationResults.class);
        } catch (IOException |InterruptedException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
