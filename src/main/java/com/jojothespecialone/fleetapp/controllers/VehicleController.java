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
public class VehicleController {


    @Autowired private VehicleService vehicleService;
    @Autowired private VehicleMakeService vehicleMakeService;
    @Autowired private VehicleModelService vehicleModelService;
    @Autowired private VehicleTypeService vehicleTypeService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleStatusService vehicleStatusService;
    @Autowired private EmployeeService employeeService;


    //Get All VehicleMaintenances
    @GetMapping("/vehicles")
    public String getVehicle(Model model){
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMake();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<Location> locationList = locationService.getLocations();
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModel();
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehiclesType();
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
        List<Employee> employeeList = employeeService.getEmployees();

        model.addAttribute("vehicleMake", vehicleMakeList);
        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("locations", locationList);
        model.addAttribute("vehicleModel", vehicleModelList);
        model.addAttribute("vehicleStatus", vehicleStatusList);
        model.addAttribute("vehicleType", vehicleTypeList);
        model.addAttribute("employees", employeeList);

        return "vehicle";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id){
        return vehicleService.findById(id);
    }

    //Add VehicleMaintenance
    @PostMapping(value = "vehicles/addNew")
    public String addNew(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
