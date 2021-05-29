package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.VehicleHire;
import com.jojothespecialone.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {


    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getVehicleHire() {
        return vehicleHireRepository.findAll();
    }

    public Optional<VehicleHire> findById(Integer id) {
        return vehicleHireRepository.findById(id);
    }

    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }


    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
