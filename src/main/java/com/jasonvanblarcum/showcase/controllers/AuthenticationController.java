package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.UserRepository;
import com.jasonvanblarcum.showcase.models.User;
import com.jasonvanblarcum.showcase.models.dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HomeController homeController;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session);
    Integer userId = (Integer) session.getAttribute(userSessionKey);
    if (userId == null) {
        return null;
    }

    Optional<User> user = userRepository.findById(userId);

    if(user.isEmpty()) {
        return null;
    }
    return user.get();
    }

    private static void setUserInSession (HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

@GetMapping("/register")
public String displayRegistrationForm(Model model) {

        model.addAttribute(new RegistrationFormDTO());
        model.addAttribute("user", user);

        return "register";
        }
}