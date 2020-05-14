package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.models.Post;
import com.jasonvanblarcum.showcase.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ForumController {

    @Autowired
    private PostService postService;

    @GetMapping("/forum")
    public String displayForum(Model model) {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5Posts", latest5Posts);
        model.addAttribute("title", "Forum");

        List<Post> latest3Posts = latest5Posts.stream()
        .limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        return "forum";
    }

    public String displayCreatePost(Model model) {
        model.addAttribute("title", "Create Post");
        model.addAttribute(new Post());
        return "posts/create";
    }
}
