package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class IndexController {

    private final TourService tourService;

    public IndexController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/index")
    public String getPromotedTours(Model model){
        List<Tour> listOfPromotedTours = tourService.getAllTours()
                .stream().filter(tour -> tour.getIsPromoted() == 1)
                .collect(Collectors.toList());
        List<Tour> listOfTours = tourService.getAllTours();
        model.addAttribute("tours",listOfTours);
        model.addAttribute("promotedTours", listOfPromotedTours);
        return "index";
    }
}
