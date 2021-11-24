package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.model.User;
import com.finalProject.travelAgency.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order entity){
        return orderRepository.save(entity);
    }

    public List<Order> getOrdersByUserId(User user){
        return orderRepository.findByUser(user);
    }
}
