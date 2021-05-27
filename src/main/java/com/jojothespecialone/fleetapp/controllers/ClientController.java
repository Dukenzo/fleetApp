package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.Client;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.services.ClientService;
import com.jojothespecialone.fleetapp.services.CountryService;
import com.jojothespecialone.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ClientService clientService;

    //Get All clients
    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clientList = clientService.getClients();
        List<Country> countryList = countryService.getCountries();
        List<State> stateList = stateService.getStates();

        model.addAttribute("clients", clientList);
        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        return "client";
    }

    @RequestMapping("clients/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id){
        return clientService.findById(id);
    }

    //Add Client
    @PostMapping(value = "clients/addNew")
    public String addNew(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        clientService.delete(id);
        return "redirect:/clients";
    }
}
