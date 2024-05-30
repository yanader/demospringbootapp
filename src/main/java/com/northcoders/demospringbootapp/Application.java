package com.northcoders.demospringbootapp;

import com.northcoders.demospringbootapp.DAO.GeocodingDAO;
import com.northcoders.demospringbootapp.DAO.SunRiseSetDAO;
import com.northcoders.demospringbootapp.model.LocationResults;
import com.northcoders.demospringbootapp.model.SunRiseSetResults;

import java.net.URISyntaxException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        askForInput();
    }

    public static void askForInput() {

        Scanner sc = new Scanner(System.in);
        SunRiseSetResults sunriseSet;
        String userInput;
        while(true) {
            System.out.print("Please input a city name: ");
            userInput = sc.nextLine();
            try {
                LocationResults latLng = GeocodingDAO.getData(userInput);
                sunriseSet = SunRiseSetDAO.getSunRiseSetResult(latLng.results().getFirst().latitude()
                        , latLng.results().getFirst().longitude());
                break;
            } catch (NullPointerException e) {
                System.out.println("[!] ERROR city name not recognised!");
                System.out.println("Please try again.");
            }
        }
        System.out.println("**Input: " + userInput + "**");
        System.out.println("**Output: Sunrise: " + sunriseSet.results().sunrise() +", Sunset: "+sunriseSet.results().sunset()+ "**");



    }

}
