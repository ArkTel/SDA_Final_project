package com.finalProject.travelAgency.repository;

import com.finalProject.travelAgency.model.Order;
import com.finalProject.travelAgency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order,Long> {

    List<Order> findByUser(User user);
}
