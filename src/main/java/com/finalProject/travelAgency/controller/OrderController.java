package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.OrderService;
import com.finalProject.travelAgency.service.TourService;
import com.finalProject.travelAgency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final TourService tourService;
    private final UserService userService;

    public OrderController(OrderService orderService, TourService tourService, UserService userService) {
        this.orderService = orderService;
        this.tourService = tourService;
        this.userService = userService;
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
        return "confirmorder";
    }


    @GetMapping("/orderconfirmed")
    public String postOrderConfirmed() {
        return "orderconfirmed";
    }
}
