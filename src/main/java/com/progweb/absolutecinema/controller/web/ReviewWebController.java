package com.progweb.absolutecinema.controller.web;

import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.services.ReviewService;
import com.progweb.absolutecinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewWebController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String review() {
        return "review/index";
    }

    @GetMapping("/create")
    public String createReview(){
        return "review/review-form";
    }

    @GetMapping("/{id}")
    public String reviewId(@PathVariable String id, Model model) {
        model.addAttribute("review", review());
        return "review/index";
    }

    public boolean isValid(Review review){

        return true;
    }


}