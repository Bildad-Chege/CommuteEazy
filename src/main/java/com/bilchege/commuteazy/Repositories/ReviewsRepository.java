package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewsRepository extends CrudRepository<Review,Long> {
    List<Review> findReviewsByUser(Long userID);
    List<Review> findReviewsByOperator(Long operatorID);
    List<Review> findReviewsByOperatorAndUser(Long operatorID,Long userID);
}
