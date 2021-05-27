package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Vehicle;
import com.jojothespecialone.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }
}
