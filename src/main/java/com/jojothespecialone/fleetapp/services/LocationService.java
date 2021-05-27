package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Location;
import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.repositories.LocationRepository;
import com.jojothespecialone.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    //Save new state
    public void save(Location location){
        locationRepository.save(location);
    }

    //get by Id
    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    public void delete(int id) {
        locationRepository.deleteById(id);
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
}
