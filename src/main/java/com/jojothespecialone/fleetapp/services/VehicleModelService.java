package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.VehicleModel;
import com.jojothespecialone.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Save new state
    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    //get by Id
    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    public void delete(int id) {
        vehicleModelRepository.deleteById(id);
    }

    public List<VehicleModel> getVehicleModel() {
        return vehicleModelRepository.findAll();
    }
}
