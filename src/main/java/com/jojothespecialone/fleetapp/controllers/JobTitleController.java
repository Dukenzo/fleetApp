package com.jojothespecialone.fleetapp.controllers;


import com.jojothespecialone.fleetapp.models.JobTitle;
import com.jojothespecialone.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired private JobTitleService jobTitleService;

    @GetMapping("/jobTitle")
    public String getJobTitle(Model model){

        List<JobTitle> jobTitleList = jobTitleService.getJobTitle();

        model.addAttribute("jobTitle", jobTitleList);
        return "jobTitle";
    }

    @PostMapping("/jobTitle/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    @RequestMapping("jobTitle/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id){
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/jobTitle/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    @RequestMapping(value = "/jobTitle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id){
        jobTitleService.delete(id);
        return "redirect:/jobTitle";
    }
}
