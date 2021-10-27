package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
}
