package com.jasonvanblarcum.showcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String displayContact(Model model) {
        model.addAttribute("title", "CONTACT");
        return "contact";
    }
}
