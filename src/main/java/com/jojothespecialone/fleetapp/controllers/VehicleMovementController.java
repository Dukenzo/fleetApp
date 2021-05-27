package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.*;
import com.jojothespecialone.fleetapp.services.LocationService;
import com.jojothespecialone.fleetapp.services.VehicleMovementService;
import com.jojothespecialone.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;
    @Autowired private VehicleMovementService vehicleMovementService;
    

    //Get All VehicleMaintenances
    @GetMapping("/vehicleMovements")
    public String getVehicleMovement(Model model){
        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovement();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("vehicleMovements", vehicleMovementList);
        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("locations", locationList);
        return "vehicleMovement";
    }

    @RequestMapping("vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id){
        return vehicleMovementService.findById(id);
    }

    //Add VehicleMaintenance
    @PostMapping(value = "vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }
}
