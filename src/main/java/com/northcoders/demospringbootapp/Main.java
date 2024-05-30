package com.northcoders.demospringbootapp;

import com.northcoders.demospringbootapp.DAO.GeocodingDAO;

public class Main {

    public static void main(String[] args) {
        System.out.println(GeocodingDAO.getData("London"));
    }
}
