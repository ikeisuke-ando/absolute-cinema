package com.progweb.absolutecinema.controller.api;

import com.progweb.absolutecinema.controller.dto.CreateReviewDto;
import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.services.ReviewService;
import com.progweb.absolutecinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> formCreateReview(@RequestBody CreateReviewDto dto, JwtAuthenticationToken token) {
        try {
            reviewService.create(dto,token);
            return ResponseEntity.ok("Avaliação salva com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar avaliação: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Review>> listAllReview(){
        List<Review> review = this.reviewService.findAll();
        return ResponseEntity.ok().body(review);
    }

}
