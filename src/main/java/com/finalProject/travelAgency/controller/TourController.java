package com.finalProject.travelAgency.controller;


import com.finalProject.travelAgency.api.weatherservice.AccuResponse.AccuweatherResponseByKey;
import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.TourService;
import com.finalProject.travelAgency.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class TourController {

    private final TourService tourService;
    private final WeatherService weatherService;

    public TourController(TourService tourService, WeatherService weatherService) {
        this.tourService = tourService;
        this.weatherService = weatherService;
    }

    @GetMapping("/tour/{tourId}")
    public String getTourById(@PathVariable("tourId") Long tourId, Model model) throws IOException {
        Tour tour = tourService.getTour(tourId);
        model.addAttribute("tour", tour);
        AccuweatherResponseByKey weatherData = weatherService.getResultFromAccuweather(tour.getTo());
        model.addAttribute("weather",weatherData);
        return "tour";
    }

    @GetMapping("/edittour/{id}")
    public String editTour(@PathVariable("id") Long id, Model model){
        Tour tour = tourService.getTour(id);
        model.addAttribute("tour",tour);
        return "edittour";
    }

    @PostMapping("/edittour/{id}")
    public RedirectView postEditTour(@PathVariable("id") Long id, @ModelAttribute Tour updatedTour){
        tourService.save(updatedTour);
        return  new RedirectView("/alltours");
    }

    @GetMapping("/copytour/{id}")
    public String copyTour(@PathVariable("id") Long id, Model model){
        Tour tour = tourService.getTour(id);
        model.addAttribute("tour",tour);
        return "copytour";
    }

    @PostMapping("/copytour")
    public RedirectView postCopyTour(@ModelAttribute Tour newTour){
        tourService.save(newTour);
        return new RedirectView("/alltours");
    }

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
