package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.PostRepository;
import com.jasonvanblarcum.showcase.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ForumController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/forum")
    public String displayForum(Model model) {
        model.addAttribute("Post", postRepository.findAll());
        model.addAttribute("title", "Forum");
        return "forum";
    }
}
