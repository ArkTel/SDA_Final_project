package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Tour save(Tour entity) {
        return tourRepository.save(entity);
    }

    public Tour getTour(Long id) {
        return tourRepository.getById(id);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public List<Tour> getAllUpcomingTours() {
        return getAllTours().stream()
                .filter(tour -> tour.getArrivalDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Tour> getListOfPromotedTours() {
        return getAllUpcomingTours().stream()
                .filter(tour -> tour.getIsPromoted() == true)
                .collect(Collectors.toList());
    }

    public List<Tour> getListOfUpcomingTours() {
        return getAllUpcomingTours().stream()
                .filter(tour -> tour.getArrivalDate().isBefore(LocalDate.now().plusDays(30)))
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Tour> getListOfPastTours() {
        return getAllTours().stream()
                .filter(tour -> tour.getArrivalDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Tour> getListOfUpcomingToursByDestinationCity(String destinationCity) {
        return tourRepository.findByToContainingIgnoreCase(destinationCity)
                .stream()
                .filter(tour -> tour.getArrivalDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }




}
