package com.jojothespecialone.fleetapp.controllers;

import com.jojothespecialone.fleetapp.models.User;
import com.jojothespecialone.fleetapp.models.UserPrincipal;
import com.jojothespecialone.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUser(){
        return "user";
    }

    public RedirectView addNew(User user, RedirectAttributes redir){
        userService.save(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You successfully registered! You can now login");
      return redirectView;
    }
}
