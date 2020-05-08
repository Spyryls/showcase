package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.models.Post;
import com.jasonvanblarcum.showcase.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/post/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("title", "Posts");
        return "posts/view";
    }

}
