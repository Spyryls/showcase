package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.UserRepository;
import com.jasonvanblarcum.showcase.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String root (ModelMap model) {
        List<User> allUsers = userRepo.findAll();

        User user = new User();

        model.put("allUsers", allUsers);
        model.put("user", user);

        return "register";
    }

    @PostMapping("/register")
    public String registrationPagePost (User user) {
        userRepo.save(user);

        return "redirect:/home";
    }
}

