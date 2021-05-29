package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Vehicle;
import com.jojothespecialone.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired private VehicleRepository vehicleRepository;

    //Return the List of vehicles
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    //Get Vehicle by Id
    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepository.findById(id);
    }

    //Save new vehicle
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }


    //Delete vehicle by Id
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
