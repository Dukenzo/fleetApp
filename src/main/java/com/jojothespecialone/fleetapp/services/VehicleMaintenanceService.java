package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Client;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.models.VehicleMaintenance;
import com.jojothespecialone.fleetapp.repositories.ClientRepository;
import com.jojothespecialone.fleetapp.repositories.CountryRepository;
import com.jojothespecialone.fleetapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {

    @Autowired private VehicleMaintenanceRepository vehicleMaintenanceRepository;
    @Autowired private CountryRepository countryRepository;


    //Get Client by Id
    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenanceRepository.findById(id);
    }

    //Delete Client
    public void delete(int id){
        vehicleMaintenanceRepository.deleteById(id);
    }

    //Update Client
    public void save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public List<VehicleMaintenance> getVehicleMaintenance() {
        return vehicleMaintenanceRepository.findAll();
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

}
