package com.finalProject.travelAgency.controller;


import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tour/{tourId}")
    public String getTour(@PathVariable("tourId") Long tourId, Model model){
        Tour tour = tourService.getTour(tourId);
        model.addAttribute("tour", tour);
        return "tour";
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


}
