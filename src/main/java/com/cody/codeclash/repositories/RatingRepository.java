package com.cody.codeclash.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.Rating;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Long> {

    List<Rating> findAllByProblem(Problem problem);

    Rating findByProblemAndUserId(Problem problem, Long userId);
}
