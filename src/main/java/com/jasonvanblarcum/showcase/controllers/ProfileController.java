package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import com.jasonvanblarcum.showcase.data.UserRepository;
import com.jasonvanblarcum.showcase.models.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile/{userId}")
    public String displayProfile(Model model, @PathVariable int userId) {
        model.addAttribute("Artwork", artworkRepository.findAll());
        model.addAttribute("title", "Profile");
        return "profile/index";
    }

    @GetMapping("upload")
    public String displayUploadArtwork(Model model) {
        model.addAttribute(new Artwork());
        return "profile/upload";
    }
}
