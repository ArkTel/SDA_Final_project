package com.finalProject.travelAgency.repository;

import com.finalProject.travelAgency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    List<Tour> findByToContainingIgnoreCase(String to);
}
