package com.finalProject.travelAgency.api.rest;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/tours")
public class TourRestController {

    private final TourService tourService;

    public TourRestController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<Tour>> getAllUpcomingTours(){
        return ResponseEntity.ok(tourService.getListOfUpcomingTours());
    }

    @GetMapping("/past")
    public ResponseEntity<List<Tour>> getAllPastTours(){
        return ResponseEntity.ok(tourService.getListOfPastTours());
    }

    @GetMapping("/{destinationCity}")
    public ResponseEntity<List<Tour>> getUpcomingToursByDestinationCity(@PathVariable String destinationCity){
        return ResponseEntity.ok(tourService.getListOfUpcomingToursByDestinationCity(destinationCity));
    }
}
