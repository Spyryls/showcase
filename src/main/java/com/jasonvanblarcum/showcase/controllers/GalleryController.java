package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.ArtworkRepository;
import com.jasonvanblarcum.showcase.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@Controller
public class GalleryController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtworkRepository artworkRepository;

    @GetMapping("/gallery")
    public String displayGallery(Model model) {
        model.addAttribute("title", "GALLERY");
        model.addAttribute("artworks", artworkRepository.findAll());
        return "gallery";
    }
}