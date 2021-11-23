package com.finalProject.travelAgency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
//
//    @PostMapping("/login")
//    public RedirectView userLogin(){
//        return new RedirectView("/index") ;
//    }


}
