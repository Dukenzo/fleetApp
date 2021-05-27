package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.repositories.CountryRepository;
import com.jojothespecialone.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired private CountryRepository countryRepository;
    @Autowired private StateRepository stateRepository;

    public Object getCountries;

    //Return list of countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    //Save new country
    public void save(Country country){
        countryRepository.save(country);
    }

    //get by Id
    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    public void delete(int id) {
        countryRepository.deleteById(id);
    }

    public List<State> getStates() {
        return stateRepository.findAll();
    }
}
