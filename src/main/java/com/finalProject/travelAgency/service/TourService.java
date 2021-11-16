package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<Tour> getAllTours () {return tourRepository.findAll();}

    public List<Tour> getListOfPromotedTours(){
        return getAllTours().stream()
                .filter(tour -> tour.getArrivalDate().isAfter(LocalDate.now()))
                .filter(tour -> tour.getIsPromoted() == true)
                .collect(Collectors.toList());
    }

    public List<Tour> getListOfUpcomingTours(){
        return getAllTours().stream()
                .filter(tour -> tour.getArrivalDate().isAfter(LocalDate.now()))
                .filter(tour -> tour.getArrivalDate().isBefore(LocalDate.now().plusDays(30)))
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Tour> getListOfPastTours(){
        return getAllTours().stream()
                .filter(tour -> tour.getArrivalDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public Tour updateTour(Long id, Tour tour){
        Tour tourToUpdate = tourRepository.getById(id);
        tourToUpdate.setFrom(tour.getFrom());
        tourToUpdate.setTo(tour.getTo());
        tourToUpdate.setArrivalDate(tour.getArrivalDate());
        tourToUpdate.setDepartureDate(tour.getDepartureDate());
        tourToUpdate.setOffersType(tour.getOffersType());
        tourToUpdate.setPriceForAdult(tour.getPriceForAdult());
        tourToUpdate.setPriceForChild(tour.getPriceForChild());
        tourToUpdate.setIsPromoted(tour.getIsPromoted());
        tourToUpdate.setAvailablePlacesForAdult(tour.getAvailablePlacesForAdult());
        tourToUpdate.setAvailablePlacesForChildren(tour.getAvailablePlacesForChildren());
        tourToUpdate.setTourDescription(tour.getTourDescription());
        tourToUpdate.setImgLink(tour.getImgLink());
        tourRepository.save(tourToUpdate);
        return tourToUpdate;
    }


}
