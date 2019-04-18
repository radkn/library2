package com.lib.training.controller;

import com.lib.training.model.entities.User;
import com.lib.training.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistratinController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid User user, BindingResult bindingResult, Model model){

        if(!user.getPassword().equals(user.getPassword2())){
            model.addAttribute("passwordError", "Passwords are different!");
            return "registration";
        }

        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }

        if(!userService.addUser(user)){
            model.addAttribute("message", "User already exists!");
            return "registration";
        }

        return "redirect:/login";
    }
}
