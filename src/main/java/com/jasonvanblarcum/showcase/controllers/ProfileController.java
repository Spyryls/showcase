package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import com.jasonvanblarcum.showcase.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProfileController {

    @Autowired
    ArtworkRepository artworkRepository;

    @GetMapping("/profile")
    public String displayProfile(Model model) {
        model.addAttribute("Artwork", artworkRepository.findAll());
        model.addAttribute("title", "Profile");
        return "profile";
    }
}
