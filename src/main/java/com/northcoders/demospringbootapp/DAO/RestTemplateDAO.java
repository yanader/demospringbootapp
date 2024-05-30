package com.northcoders.demospringbootapp.DAO;

import com.northcoders.demospringbootapp.model.LocationResults;
import com.northcoders.demospringbootapp.model.LongLat;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


public class RestTemplateDAO {

    private final static String BASE_URL = "https://geocoding-api.open-meteo.com/v1/search";

    public static LocationResults getData(String city) {

        RestTemplate restTemplate = new RestTemplate();
        LocationResults results = restTemplate.getForObject(BASE_URL + "?name=" + city, LocationResults.class);
        return results;

    }

    public static LocationResults getDataAgain(String city) {
        RestClient restClient = RestClient.create();
        LocationResults results = restClient.get()
                .uri(BASE_URL + "?name=" + city)
                .retrieve()
                .body(LocationResults.class);
        return results;


    }
}
