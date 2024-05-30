package com.northcoders.demospringbootapp.DAO;

import com.northcoders.demospringbootapp.model.LocationResults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.*;
import reactor.core.publisher.Mono;

public class WebClientDAO {

    private final static String BASE_URL = "https://geocoding-api.open-meteo.com/v1/search";

    public static LocationResults getData(String city) {
        WebClient client = WebClient.builder()
                .baseUrl(BASE_URL + "?name=" + city)
                .build();

        return client.get()
                .retrieve()
                .bodyToMono(LocationResults.class)
                .block();
    }
}
