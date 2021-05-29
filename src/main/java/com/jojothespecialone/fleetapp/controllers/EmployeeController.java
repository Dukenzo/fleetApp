package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.*;
import com.jojothespecialone.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired private EmployeeTypeService employeeTypeService;
    @Autowired private JobTitleService jobTitleService;
    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private EmployeeService employeeService;


    //Get All VehicleMaintenances
    @GetMapping("/employees")
    public String getEmployees(Model model){

        List<Country> countryList = countryService.getCountries();
        List<State> stateList = stateService.getStates();
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeType();
        List<JobTitle> jobTitleList = jobTitleService.getJobTitle();
        List<Employee> employeeList = employeeService.getEmployees();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("employeeType", employeeTypeList);
        model.addAttribute("jobTitle", jobTitleList);
        model.addAttribute("employees", employeeList);

        return "employee";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id){
        return employeeService.findById(id);
    }

    //Add VehicleMaintenance
    @PostMapping(value = "employees/addNew")
    public String addNew(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
