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
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public String displayUserProfile(@PathVariable("id") Integer id, Model model) {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            model.addAttribute("user", user);
            return "id";
        } else {
            return "redirect:../";
        }
    }

/*    @GetMapping(value = "{artworkId}")
    public String displayArtwork(@PathVariable Integer artworkId, Model model) {
        Optional<Artwork> optArtwork = artworkRepository.findById(artworkId);
        if (optArtwork.isPresent()) {
            Artwork artwork = optArtwork.get();
            model.addAttribute("artwork", artwork);
            return "redirect:/view/{artworkId}";
        } else {
            return "redirect:../";
        }
    }*/

    @GetMapping("/upload")
    public String displayUploadArtwork(Model model) {
        model.addAttribute(new Artwork());
        return "redirect:/profile/upload";
    }
}
