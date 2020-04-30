package com.jasonvanblarcum.showcase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping
    public String displayHome(RedirectAttributes redirectAttributes) {
        return "redirect:/home"; }

}