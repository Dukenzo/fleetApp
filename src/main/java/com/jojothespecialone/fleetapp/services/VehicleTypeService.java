package com.jojothespecialone.fleetapp.services;

import com.jojothespecialone.fleetapp.models.VehicleType;
import com.jojothespecialone.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    //Save new state
    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    //get by Id
    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    public void delete(int id) {
        vehicleTypeRepository.deleteById(id);
    }

    public List<VehicleType> getVehiclesType() {
        return vehicleTypeRepository.findAll();
    }
}
