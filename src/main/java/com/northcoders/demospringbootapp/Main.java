package com.northcoders.demospringbootapp;

import com.northcoders.demospringbootapp.DAO.GeocodingDAO;
import com.northcoders.demospringbootapp.DAO.RestTemplateDAO;

public class Main {

    public static void main(String[] args) {

        System.out.println(RestTemplateDAO.getDataAgain("London").results().getFirst().latitude());
        System.out.println(RestTemplateDAO.getDataAgain("London").results().getFirst().longitude());
        System.out.println(RestTemplateDAO.getDataAgain("London").results().getFirst().country_code());


         }
}
