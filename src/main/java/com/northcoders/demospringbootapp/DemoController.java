package com.northcoders.demospringbootapp;

import com.northcoders.demospringbootapp.DAO.GeocodingDAO;
import org.springframework.web.bind.annotation.*;
import com.northcoders.demospringbootapp.model.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello")
    public String getGreeting(){
        return "Hello there!";
    }


    @GetMapping("/people")
    public List<Person> getPeople(){
        return initPeople();
    }

    private List<Person> initPeople(){
        List<Person> pplList = new ArrayList<>();
        pplList.add(new Person("Bob",28,"bob321@gmail.com","London","pizza"));
        pplList.add(new Person("Angela",30,"angela.valdez@outlook.com","Manchester","ramen"));
        return pplList;
    }

    @GetMapping("/longlat/{city}/{country_code}")
    public LongLat getLongLat(@PathVariable String city,@PathVariable String country_code){
        List<LongLat> result = GeocodingDAO.getData(city).results();
        for(LongLat i : result){
            if(i.country_code().equalsIgnoreCase(country_code)){
                return i;
            }
        }
        return result.getFirst();
    }








}
