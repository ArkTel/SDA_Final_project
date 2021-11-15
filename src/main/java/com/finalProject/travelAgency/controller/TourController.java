package com.finalProject.travelAgency.controller;


import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tour/{tourId}")
    public String getTourById(@PathVariable("tourId") Long tourId, Model model){
        Tour tour = tourService.getTour(tourId);
        model.addAttribute("tour", tour);
        return "tour";
    }

    @GetMapping("/tour/{id}")
    public String editTour(@PathVariable("tourId") Long tourId, Model model){
        Tour tour = tourService.getTour(tourId);
        model.addAttribute("tour", tour);
        return "edittour";
    }
//    @GetMapping("/tour")
//    public String getTour(){
////        Tour tour = tourService.getTour(tourId);
////        model.addAttribute("tour", tour);
//        return "tour";
//    }

    @GetMapping("/addtour")
    public String getAddTour(){
        return "addtour";
    }

    @PostMapping("/addtour")
    public RedirectView postAddTour(@ModelAttribute Tour newTour){
        tourService.save(newTour);
        return new RedirectView("/addtour");
    }

    //find showTours
    @GetMapping("/alltours")
    public String getAllTours(Model model){
        List<Tour> listOfTours = tourService.getAllTours();
        model.addAttribute("tours",listOfTours);
        return "alltours";
    }

    @GetMapping("/archive")
    public String getToursArchive(Model model){
        List<Tour> listOfTours = tourService.getListOfPastTours();
        model.addAttribute("tours",listOfTours);
        return "archive";
    }


}
