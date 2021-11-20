package com.finalProject.travelAgency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @GetMapping("/paneladmin")
    public String getPanelAdmin(){
        return "paneladmin";
    }
}
