package com.progweb.absolutecinema.controller.api;

import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<?> formCreateReview(@RequestBody Review review) {
        try {
            reviewService.create(review);
            return ResponseEntity.ok("Avaliação salva com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar série: " + e.getMessage());
        }
    }
}
