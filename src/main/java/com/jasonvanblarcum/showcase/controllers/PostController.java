package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.PostRepository;
import com.jasonvanblarcum.showcase.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/post/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Optional post = postRepository.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("title", "Posts");
        return "posts/view";
    }

}
