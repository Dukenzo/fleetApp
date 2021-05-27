package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.EmployeeType;
import com.jojothespecialone.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    //Save new state
    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    //get by Id
    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    public void delete(int id) {
        employeeTypeRepository.deleteById(id);
    }

    public List<EmployeeType> getEmployeeType() {
        return employeeTypeRepository.findAll();
    }
}
