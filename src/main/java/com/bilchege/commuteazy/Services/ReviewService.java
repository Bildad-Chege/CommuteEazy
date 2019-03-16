package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Entities.Review;
import com.bilchege.commuteazy.Entities.User;
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

    public List<Review> getReviewbyUser(User user){
        List<Review> reviews = new ArrayList<>();
        reviewsRepository.findReviewsByUser(user).forEach(reviews::add);
        return reviews;
    }

    public List<Review> getReviewbyOperator(Operator operator){
        List<Review> reviews = new ArrayList<>();
        reviewsRepository.findReviewsByOperator(operator).forEach(reviews::add);
        return reviews;
    }

    public List<Review> getReviewbyOperatorAndUser(Operator operator,User user){
        List<Review> reviews = new ArrayList<>();
        reviewsRepository.findReviewsByOperatorAndUser(operator,user).forEach(reviews::add);
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
