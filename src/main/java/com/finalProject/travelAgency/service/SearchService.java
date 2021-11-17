package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SearchService {
    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Tour> searchTour(String to, LocalDate date){
       return searchRepository.searchTour(to, date);
    }

    public List<Tour> findTour(String to, LocalDate date, LocalDate date2){
        return searchRepository.findByToContainingIgnoreCaseAndArrivalDateBeforeAndDepartureDateAfter(to, date, date2);
    }
}
