package com.finalProject.travelAgency.service;

import com.finalProject.travelAgency.repository.ContinentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }
}
