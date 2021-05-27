package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.Supplier;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.models.Supplier;
import com.jojothespecialone.fleetapp.services.SupplierService;
import com.jojothespecialone.fleetapp.services.CountryService;
import com.jojothespecialone.fleetapp.services.StateService;
import com.jojothespecialone.fleetapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {


    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private SupplierService supplierService;

    //Get All Suppliers
    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        List<Supplier> supplierList = supplierService.getSuppliers();
        List<Country> countryList = countryService.getCountries();
        List<State> stateList = stateService.getStates();

        model.addAttribute("suppliers", supplierList);
        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        return "supplier";
    }

    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id){
        return supplierService.findById(id);
    }

    //Add Supplier
    @PostMapping(value = "suppliers/addNew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
