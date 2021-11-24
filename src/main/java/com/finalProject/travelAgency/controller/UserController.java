package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.model.User;
import com.finalProject.travelAgency.service.OrderService;
import com.finalProject.travelAgency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;
    private final OrderService orderService;

    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping("/registration")
    public RedirectView postAddUser(@ModelAttribute User newUser) {
        userService.save(newUser);
        return new RedirectView("/");
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @GetMapping("/allusers")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers()
                .stream()
                .filter(user -> user.getId() != 1)
                .collect(Collectors.toList());
        model.addAttribute("users", users);
        return "allusers";
    }

    @GetMapping("/edituser/{id}")
    public String getEditUserById(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/edituser/{id}")
    public RedirectView postEditUserById(@PathVariable("id") Long id, @ModelAttribute User updatedUser) {
        userService.editUser(id, updatedUser);
        return new RedirectView("/allusers");
    }

    @GetMapping("/purchasedtours/{id}")
    public String getPurchasedToursByUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        List<Order> orders = orderService.getOrdersByUserId(user);
        model.addAttribute("orders", orders);
        return "purchasedtours";
    }

    @GetMapping("/paneluser")
    public String getUserPanel() {
        return "paneluser";
    }

    @GetMapping("/myprofile")
    public String getMyProfile(Principal principal, Model model) {
        User user = userService.getUser(principal.getName());
        model.addAttribute("user", user);
        return "myprofile";
    }

    @GetMapping("/purchasedtours")
    public String getPurchasedTours(Principal principal, Model model) {
        User user = userService.getUser(principal.getName());
        List<Order> orders = orderService.getOrdersByUserId(user);
        model.addAttribute("orders", orders);
        return "purchasedtours";
    }

    @GetMapping("/edituser")
    public String getEditUser(Principal principal, Model model) {
        User user = userService.getUser(principal.getName());
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/edituser")
    public RedirectView postEditUser(@ModelAttribute User updatedUser, Principal principal) {
        userService.editUser(userService.getUser(principal.getName()).getId(), updatedUser);
        return new RedirectView("/myprofile");
    }

}
