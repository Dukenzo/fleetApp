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
public class VehicleMaintenanceController {


    @Autowired private SupplierService supplierService;
    @Autowired private VehicleService vehicleService;
    @Autowired private VehicleMaintenanceService vehicleMaintenanceService;

    //Get All VehicleMaintenances
    @GetMapping("/vehicleMaintenance")
    public String getVehicleMaintenance(Model model){
        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenance();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<Supplier> supplierList = supplierService.getSuppliers();

        model.addAttribute("vehicleMaintenance", vehicleMaintenanceList);
        model.addAttribute("vehicles", vehicleList);
        model.addAttribute("suppliers", supplierList);
        return "vehicleMaintenance";
    }

    @RequestMapping("vehicleMaintenance/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id){
        return vehicleMaintenanceService.findById(id);
    }

    //Add VehicleMaintenance
    @PostMapping(value = "vehicleMaintenance/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value = "vehicleMaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value = "vehicleMaintenance/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenance";
    }
}
