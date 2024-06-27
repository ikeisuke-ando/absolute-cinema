package com.progweb.absolutecinema.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexWebController {

    @GetMapping("/")
    public String index(Model model) {
        boolean loggedIn = false;
        model.addAttribute("loggedIn", loggedIn);
        return "index";
    }
}