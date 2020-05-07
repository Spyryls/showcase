package com.jasonvanblarcum.showcase.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ContactController {

    @GetMapping("/contact")
    public String displayContactForm(Model model) {
        model.addAttribute("title", "CONTACT");
        return "contact";
    }
}
