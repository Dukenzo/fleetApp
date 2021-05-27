package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.VehicleMovement;
import com.jojothespecialone.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {

    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    public List<VehicleMovement> getVehicleMovement() {
        return vehicleMovementRepository.findAll();
    }

    public Optional<VehicleMovement> findById(Integer id) {
        return vehicleMovementRepository.findById(id);
    }

    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }


    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }
}
