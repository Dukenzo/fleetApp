package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.Contact;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.services.ContactService;
import com.jojothespecialone.fleetapp.services.CountryService;
import com.jojothespecialone.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {


    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ContactService contactService;

    //Get All contacts
    @GetMapping("/contacts")
    public String getContacts(Model model){
        List<Contact> contactList = contactService.getContacts();
        List<Country> countryList = countryService.getCountries();
        List<State> stateList = stateService.getStates();

        model.addAttribute("contacts", contactList);
        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        return "contact";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id){
        return contactService.findById(id);
    }

    //Add contact
    @PostMapping(value = "/contacts/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
