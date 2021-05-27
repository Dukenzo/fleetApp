package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Supplier;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.repositories.SupplierRepository;
import com.jojothespecialone.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {


    @Autowired private SupplierRepository supplierRepository;
    @Autowired private CountryRepository countryRepository;


    //Get Supplier by Id
    public Optional<Supplier> findById(int id){
        return supplierRepository.findById(id);
    }

    //Delete Supplier
    public void delete(int id){
        supplierRepository.deleteById(id);
    }

    //Update Supplier
    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
