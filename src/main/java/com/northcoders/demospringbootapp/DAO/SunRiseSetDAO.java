package com.northcoders.demospringbootapp.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.model.SunRiseSetResults;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SunRiseSetDAO {

    private final static String BASE_URL = "https://api.sunrisesunset.io/json";

    public static SunRiseSetResults getSunRiseSetResult(double lat, double lng) {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "?lat=" + lat + "&lng=" + lng))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            client.close();
            return mapper.readValue(response.body(), SunRiseSetResults.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Query Failed");
            throw new RuntimeException(e);
        }
    }
}
