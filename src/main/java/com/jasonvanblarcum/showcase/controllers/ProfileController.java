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

import java.util.Optional;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Applicable Skills");
        model.addAttribute("user", userRepository.findAll());
        return "profile/index";
    }

    @GetMapping("/profile/{artworkId}")
    public String displayProfile(Model model, @PathVariable int userId) {
        Optional<Artwork> optArtwork = artworkRepository.findById(userId);
        if (optArtwork.isPresent()) {
            Artwork artwork = optArtwork.get();
            model.addAttribute("artwork", artwork);
            return "profile/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("upload")
    public String displayUploadArtwork(Model model) {
        model.addAttribute(new Artwork());
        return "profile/upload";
    }
}
