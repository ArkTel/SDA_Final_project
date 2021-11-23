package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.model.OrderForm;
import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.model.User;
import com.finalProject.travelAgency.service.OrderService;
import com.finalProject.travelAgency.service.TourService;
import com.finalProject.travelAgency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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

//    public String postConfirmOrder(Principal principal){
//        userService.getUser(principal.getName()).getId();

    @PostMapping("/confirmorder/{id}")
    public String postConfirmOrder(@ModelAttribute OrderForm orderForm,@PathVariable("id") Long id, Model model){
        orderForm.setTourId(id);
        BigDecimal sum = (tourService.getTour(orderForm.getTourId()).getPriceForAdult().multiply(new BigDecimal(orderForm.getOrderPlacesForAdults())))
                .add(tourService.getTour(orderForm.getTourId()).getPriceForChild().multiply(new BigDecimal(orderForm.getOrderPlacesForChildren())));
        model.addAttribute("order", orderForm);
        model.addAttribute("sum", sum);
        return "confirmorder";
    }
//    @GetMapping("/confirmorder")
//    public String getConfirmOrder(OrderForm oderform){
////        userService.getUser(principal.getName()).getId();
//
//        return "confirmorder";
//    }

    @PostMapping("/orderconfirmed")
    public String postOrderConfirmed(@ModelAttribute(name = "order") OrderForm order, Principal principal){
        Order newOrder = Order.builder()
                .userId(userService.getUser(principal.getName()))
                .orderPlacesForAdults(order.getOrderPlacesForAdults())
                .orderPlacesForChildren(order.getOrderPlacesForChildren())
                .tourId(tourService.getTour(order.getTourId()))
                .totalPrice(order.getSum())
                .build();
        orderService.save(newOrder);
        return "orderconfirmed";
    }
}
