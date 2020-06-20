package com.jasonvanblarcum.showcase.controllers;

import com.jasonvanblarcum.showcase.data.UserRepository;
import com.jasonvanblarcum.showcase.controllers.AuthenticationController;
import com.jasonvanblarcum.showcase.models.User;
import com.jasonvanblarcum.showcase.models.dto.RegistrationFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String displayHome(HttpServletRequest request, Model model) {
/*
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
*/

        String username = request.getRemoteUser();
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "index";
    }
}
