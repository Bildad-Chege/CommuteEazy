package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Entities.Review;
import com.bilchege.commuteazy.Entities.User;
import com.bilchege.commuteazy.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method = RequestMethod.POST,value = "/addReview")
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    @RequestMapping("/getReview/{id}")
    public Optional<Review> getReview(@PathVariable("id") Long id){
        return reviewService.getReview(id);
    }

    @RequestMapping("/getReviews")
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }

    @RequestMapping("/reviewsbyuser/{id}")
    public List<Review> getReviewsByUser(@PathVariable("id") User user){
        return reviewService.getReviewbyUser(user);
    }

    @RequestMapping("/reviewsforoperator/{id}")
    public List<Review> getReviewsbyOperator(@PathVariable Operator operator){
        return reviewService.getReviewbyOperator(operator);
    }

    @RequestMapping("/reviewsforoperator/{opid}/byuser/{uid}")
    public List<Review> getReviewsforOperatorbyUser(@PathVariable("opid") Operator operator,@PathVariable("uid") User user){
        return reviewService.getReviewbyOperatorAndUser(operator, user);
    }

    @RequestMapping("/updatereview/{id}")
    public void updateReview(@RequestBody Review review,@PathVariable("id") Long id){
        reviewService.updateReview(review,id);
    }

    @RequestMapping("/deletereview/{id}")
    public void deleteReview(@PathVariable("id") Long id){
        reviewService.deleteReview(id);
    }
}
