package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.Client;
import com.jojothespecialone.fleetapp.models.Location;
import com.jojothespecialone.fleetapp.models.Vehicle;
import com.jojothespecialone.fleetapp.models.VehicleHire;
import com.jojothespecialone.fleetapp.services.ClientService;
import com.jojothespecialone.fleetapp.services.LocationService;
import com.jojothespecialone.fleetapp.services.VehicleHireService;
import com.jojothespecialone.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {


    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;
    @Autowired private ClientService clientService;
    @Autowired private VehicleHireService vehicleHireService;


    //Get All VehicleMaintenances
    @GetMapping("/vehicleHire")
    public String getVehicleHire(Model model){
        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHire();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<Location> locationList = locationService.getLocations();
        List<Client> clientList = clientService.getClients();

        model.addAttribute("vehicleHire", vehicleHireList);
        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("locations", locationList);
        model.addAttribute("clients", clientList);
        return "vehicleHire";
    }

    @RequestMapping("vehicleHire/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(Integer id){
        return vehicleHireService.findById(id);
    }

    //Add VehicleMaintenance
    @PostMapping(value = "vehicleHire/addNew")
    public String addNew(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value = "vehicleHire/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value = "vehicleHire/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleHireService.delete(id);
        return "redirect:/vehicleHire";
    }
}
