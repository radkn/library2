package com.lib.training.controller;

import com.lib.training.model.entities.User;
import com.lib.training.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(
            @RequestParam(name = "name", required=false, defaultValue = "guest") String name,
            Model model){
        model.addAttribute("greeting", "Hear will be Home Page!");

        return "main";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Model model){

        if(!userService.addUser(user)){
            model.addAttribute("message", "User already exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Model model){

        return "profile";
    }

}
