package com.finalProject.travelAgency.repository;

import com.finalProject.travelAgency.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order,Long> {
}
