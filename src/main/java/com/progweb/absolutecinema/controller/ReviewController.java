package com.progweb.absolutecinema.controller;

import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.model.User;
import com.progweb.absolutecinema.services.ReviewService;
import com.progweb.absolutecinema.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public String review() {
        return "review/index";
    }

    @PostMapping("/create/review")
    public String createReview(Model model, @Valid User userAdmin, @Valid Review review){
        try{




            throw new Exception("Campos obrigatórios não preenchidos!!!");
        }
        catch (Exception e) {
            model.addAttribute("registerError", e.getMessage());
            return "register/index";
        }
    }


    public boolean isValid(Review review){

        return true;
    }


}