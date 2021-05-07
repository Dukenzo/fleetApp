package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return list of countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

}
