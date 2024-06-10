package com.progweb.absolutecinema.services;

import com.progweb.absolutecinema.model.Review;
import com.progweb.absolutecinema.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public Review create(Review review){
        review.setId(null);
        return review = this.reviewRepository.save(review);
    }
}
