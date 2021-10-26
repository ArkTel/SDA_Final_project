package com.finalProject.travelAgency.repository;

import com.finalProject.travelAgency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour,Long> {
}
