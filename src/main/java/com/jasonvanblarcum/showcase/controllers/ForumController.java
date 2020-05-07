package com.jasonvanblarcum.showcase.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ForumController {

    @GetMapping("/forum")
    public String displayForumForm(Model model) {
        model.addAttribute("title", "FORUM");
        return "forum";
    }
}
