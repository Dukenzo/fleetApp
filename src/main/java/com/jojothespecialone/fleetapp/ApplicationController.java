package com.jojothespecialone.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("../resources/templates/index")
    public String goHome(){
        return "index";
    }
}
