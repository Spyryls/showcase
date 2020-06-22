package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import com.jasonvanblarcum.showcase.data.UserRepository;
import com.jasonvanblarcum.showcase.models.Artwork;
import com.jasonvanblarcum.showcase.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/profile/{userId}")
public class ProfileController {

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile/{user.id}")
    public String displayUserProfile(Model model, @PathVariable Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isPresent()) {
            User user = optUser.get();
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("/profile/view/{artworkId}")
    public String displayArtwork(Model model, @PathVariable Integer artworkId) {
        Optional<Artwork> optArtwork = artworkRepository.findById(artworkId);
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
