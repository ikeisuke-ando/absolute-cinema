package com.progweb.absolutecinema.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Authenticator;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        boolean loggedIn = false;
        model.addAttribute("loggedIn", loggedIn);
        return "index";
    }
}