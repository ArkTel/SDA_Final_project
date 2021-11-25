package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.mail.EmailConfiguration;
import com.finalProject.travelAgency.mail.EmailReminder;
import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.MailService;
import com.finalProject.travelAgency.service.OrderService;
import com.finalProject.travelAgency.service.TourService;
import com.finalProject.travelAgency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final TourService tourService;
    private final UserService userService;
    private final MailService mailService;


    public OrderController(OrderService orderService, TourService tourService, UserService userService, EmailConfiguration emailConfiguration, MailService mailService) {
        this.orderService = orderService;
        this.tourService = tourService;
        this.userService = userService;
        this.mailService = mailService;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable("id") Long id, Model model) {
        Tour tour = tourService.getTour(id);
        model.addAttribute("tour", tour);
        return "order";
    }

    @PostMapping("/confirmorder/{id}")
    public String postConfirmOrder(@ModelAttribute Order order, @PathVariable("id") Long id, Model model, Principal principal) {
        Tour tour = tourService.getTour(id);
        order.setTour(tour);
        order.setUser(userService.getUser(principal.getName()));
        BigDecimal sum = (tourService.getTour(order.getTour().getId()).getPriceForAdult().multiply(new BigDecimal(order.getOrderPlacesForAdults())))
                .add(tourService.getTour(order.getTour().getId()).getPriceForChild().multiply(new BigDecimal(order.getOrderPlacesForChildren())));
        order.setTotalPrice(sum);
        model.addAttribute("order", order);
        model.addAttribute("sum", sum);
        orderService.save(order);
        tour.setAvailablePlacesForAdult(tourService.getTour(id).getAvailablePlacesForAdult() - order.getOrderPlacesForAdults());
        tour.setAvailablePlacesForChildren(tourService.getTour(id).getAvailablePlacesForChildren() - order.getOrderPlacesForChildren());
        tourService.save(tour);
        mailService.sendEmail(order);

        return "confirmorder";
    }


    @GetMapping("/orderconfirmed")
    public String postOrderConfirmed() {
        return "orderconfirmed";
    }
}
