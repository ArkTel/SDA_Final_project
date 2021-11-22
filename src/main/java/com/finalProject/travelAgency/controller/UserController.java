package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.model.User;
import com.finalProject.travelAgency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public RedirectView postAddUser(@ModelAttribute User newUser){
        userService.save(newUser);
        return new RedirectView("/");
    }

    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }

    @GetMapping("/allusers")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers()
                .stream()
                .filter(user -> user.getId() != 1)
                .collect(Collectors.toList());
        model.addAttribute("users", users);
        return "allusers";
    }

    @GetMapping("/edituser/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "edituser";
    }

    @PostMapping("/edituser/{id}")
    public RedirectView postEditUser(@PathVariable("id") Long id, @ModelAttribute User updatedUser){
        userService.save(updatedUser);
        return  new RedirectView("/allusers");
    }


}
