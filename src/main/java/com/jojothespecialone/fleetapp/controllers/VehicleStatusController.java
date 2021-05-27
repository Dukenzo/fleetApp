package com.jojothespecialone.fleetapp.controllers;


import com.jojothespecialone.fleetapp.models.VehicleStatus;
import com.jojothespecialone.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatus")
    public String getVehicleStatus(Model model){

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehicleStatus", vehicleStatusList);
        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatus/addNew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping("vehicleStatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicleStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping(value = "/vehicleStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatus";
    }
}
