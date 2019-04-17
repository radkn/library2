package com.lib.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(
            @RequestParam(name = "name", required=false, defaultValue = "guest") String name,
            Model model){
        model.addAttribute("greeting", "Hear will be Home Page!");

        return "home";
    }

    @PostMapping("/registration")
    public String registration(){

    }

}
