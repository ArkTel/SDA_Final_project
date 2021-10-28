package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.repository.TourRepository;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Tour save(Tour entity){
        return tourRepository.save(entity);
    }
    public Tour getTour(Long id){
        return tourRepository.getById(id);
    }
}
