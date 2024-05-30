package com.northcoders.demospringbootapp;

import com.northcoders.demospringbootapp.DAO.GeocodingDAO;
import com.northcoders.demospringbootapp.DAO.RestTemplateDAO;
import com.northcoders.demospringbootapp.DAO.WebClientDAO;

public class Main {

    public static void main(String[] args) {

        System.out.println(WebClientDAO.getData("London").results().getFirst().latitude());
        System.out.println(WebClientDAO.getData("London").results().getFirst().longitude());
        System.out.println(WebClientDAO.getData("London").results().getFirst().country_code());


         }
}
