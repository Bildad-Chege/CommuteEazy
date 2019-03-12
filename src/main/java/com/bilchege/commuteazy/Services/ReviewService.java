package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.Review;
import com.bilchege.commuteazy.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public void addReview(Review review){
        reviewsRepository.save(review);
    }

    public Optional<Review> getReview(Long id){
        return reviewsRepository.findById(id);
    }

    public List<Review> getReviewbyUser(Long userID){
        List<Review> reviews = new ArrayList<>();
        reviewsRepository.findReviewsByUser(userID).forEach(reviews::add);
        return reviews;
    }

    public List<Review> getReviewbyOperator(Long operatorID){
        List<Review> reviews = new ArrayList<>();
        reviewsRepository.findReviewsByOperator(operatorID).forEach(reviews::add);
        return reviews;
    }

    public List<Review> getReviewbyOperatorAndUser(Long operatorID,Long userID){
        List<Review> reviews = new ArrayList<>();
        reviewsRepository.findReviewsByOperatorAndUser(operatorID,userID).forEach(reviews::add);
        return reviews;
    }

    public List<Review> getReviews(){
        List <Review> reviews = new ArrayList<>();
        reviewsRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    public void updateReview(Review review,Long id){
        reviewsRepository.save(review);
    }

    public void deleteReview(Long id){
        reviewsRepository.deleteById(id);
    }
}
