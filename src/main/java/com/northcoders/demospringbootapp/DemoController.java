package com.northcoders.demospringbootapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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







}
