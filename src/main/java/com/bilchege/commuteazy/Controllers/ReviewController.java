package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.Review;
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
    public Optional<Review> getReview(@PathVariable Long id){
        return reviewService.getReview(id);
    }

    @RequestMapping("/getReviews")
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }

    @RequestMapping("/reviewsbyuser/{id}")
    public List<Review> getReviewsByUser(@PathVariable Long userID){
        return reviewService.getReviewbyUser(userID);
    }

    @RequestMapping("/reviewsforoperator/{id}")
    public List<Review> getReviewsbyOperator(@PathVariable Long operatorID){
        return reviewService.getReviewbyOperator(operatorID);
    }

    @RequestMapping("/reviewsforoperator/{opid}/byuser/{uid}")
    public List<Review> getReviewsforOperatorbyUser(@PathVariable("opid") Long operatorID,@PathVariable("uid") Long userID){
        return reviewService.getReviewbyOperatorAndUser(operatorID, userID);
    }

    @RequestMapping("/updatereview/{id}")
    public void updateReview(@RequestBody Review review,@PathVariable Long id){
        reviewService.updateReview(review,id);
    }

    @RequestMapping("/deletereview/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }
}
