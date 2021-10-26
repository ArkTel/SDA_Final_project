package com.finalProject.travelAgency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventsController {

    @GetMapping("/events")
    public String helloWorld(){
        return "events";
    }
}
