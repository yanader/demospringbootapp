package com.northcoders.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LocationResults(List<LongLat> results) {

}
