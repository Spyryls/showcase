package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    ArtworkRepository artworkRepository;

    @GetMapping("/profile")
    public String displayProfile(@RequestParam String username, Model model) {
        model.addAttribute("Artwork", artworkRepository.findAll());
        model.addAttribute("title", "Profile");
        return "Welcome back, " + username;
    }
}
