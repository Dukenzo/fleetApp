package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public String getStates(Model model){
        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        return "state";
    }

    @PostMapping("/states/addNew")
    public String addNew(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findById(int id){
        return stateService.findById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id){
        stateService.delete(id);
        return "redirect:/states";
    }
}
