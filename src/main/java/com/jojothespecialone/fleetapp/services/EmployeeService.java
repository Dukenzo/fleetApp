package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.Employee;
import com.jojothespecialone.fleetapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Return the List of Employees
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //Get Employee by Id
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    //Save new Employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //Delete Employee by Id
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
    
}
