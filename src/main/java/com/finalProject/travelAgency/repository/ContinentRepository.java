package com.finalProject.travelAgency.repository;

import com.finalProject.travelAgency.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent,Long> {
}
