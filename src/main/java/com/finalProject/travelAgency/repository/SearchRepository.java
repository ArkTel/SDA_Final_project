package com.finalProject.travelAgency.repository;

import com.finalProject.travelAgency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Tour,Long> {

    @Query(value = "select * from Tour t where t.value_To = :destination and :searchDate >= t.arrival_Date and :searchDate < t.departure_Date", nativeQuery = true)
    List<Tour> searchTour(@Param("destination") String to, @Param("searchDate") LocalDate date);

    List<Tour> findByToContainingIgnoreCaseAndArrivalDateBeforeAndDepartureDateAfter(String to, LocalDate date, LocalDate date2);
}
