package com.finalProject.travelAgency.controller;

import com.finalProject.travelAgency.model.SearchForm;
import com.finalProject.travelAgency.model.Tour;
import com.finalProject.travelAgency.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String getSearchView(Model model){
        model.addAttribute("searchform", new SearchForm());
        return "search";
    }
//    @GetMapping("/searchresult")
//    public String getSearchResultView(){
//        return "searchresult";
//    }

    @PostMapping ("/searchresult")
    public String getSearchResult(@ModelAttribute("searchform") SearchForm searchForm, Model model){
        List<Tour> searchResults = searchService.findTour(searchForm.getCity(),searchForm.getDate(),searchForm.getDate());
        model.addAttribute("searchresult",searchResults);
        return "searchresult";
    }


}
