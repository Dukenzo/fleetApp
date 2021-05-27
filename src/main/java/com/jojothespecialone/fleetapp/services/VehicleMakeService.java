package com.jojothespecialone.fleetapp.services;

import com.jojothespecialone.fleetapp.models.Location;
import com.jojothespecialone.fleetapp.models.VehicleMake;
import com.jojothespecialone.fleetapp.repositories.LocationRepository;
import com.jojothespecialone.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    //Save new state
    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    //get by Id
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    public void delete(int id) {
        vehicleMakeRepository.deleteById(id);
    }

    public List<VehicleMake> getVehicleMake() {
        return vehicleMakeRepository.findAll();
    }
}
