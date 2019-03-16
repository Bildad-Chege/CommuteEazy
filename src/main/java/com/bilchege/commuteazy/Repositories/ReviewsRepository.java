package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Entities.Review;
import com.bilchege.commuteazy.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewsRepository extends CrudRepository<Review,Long> {
    List<Review> findReviewsByUser(User user);
    List<Review> findReviewsByOperator(Operator operator);
    List<Review> findReviewsByOperatorAndUser(Operator operator,User user);
}
