package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.Message;
import com.finalProject.travelAgency.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private final MailService mailService;

    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/contact")
    public String helloWorld(){
        return "contact";
    }

    @PostMapping("/contact")
    public String sendMessage(@ModelAttribute Message message){
                mailService.sendAsk(message.getMessage(),message.getMessage(),message.getSubject());
        return "contact";
    }
}
