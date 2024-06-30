package com.progweb.absolutecinema.services;

import com.progweb.absolutecinema.controller.dto.CreateReviewDto;
import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public Review create(@RequestBody CreateReviewDto dto, JwtAuthenticationToken token){
//        var user = userService.findById(Long.valueOf(token.getName()));
        var review = new Review();
//        review.setUser(user);
        review.setTitle(dto.title());
        review.setRating(dto.rating());
        review.setText(dto.text());
        return reviewRepository.save(review);
    }

    public List<Review> findAll() {
        List<Review> review = reviewRepository.findAll();

        if (review.isEmpty()) {
            throw new RuntimeException("Nenhum usuário encontrado");
        }

        return review;
    }
}
