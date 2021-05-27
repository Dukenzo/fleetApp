package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Location;
import com.jojothespecialone.fleetapp.models.VehicleStatus;
import com.jojothespecialone.fleetapp.repositories.LocationRepository;
import com.jojothespecialone.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    //Save new state
    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    //get by Id
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusRepository.findById(id);
    }

    public void delete(int id) {
        vehicleStatusRepository.deleteById(id);
    }

    public List<VehicleStatus> getVehicleStatus() {
        return vehicleStatusRepository.findAll();
    }
}
