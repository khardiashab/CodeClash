package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.Rating;
import com.cody.codeclash.utils.UtilityFunctions;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository repository;

    private final ProblemService problemService;


    public void save(Long problemId, int rating) {
        Problem problem = problemService.getById(problemId);
        Rating ratingEntity = new Rating();
        ratingEntity.setProblem(Problem.builder().id(problemId).build());
        ratingEntity.setScore(rating);
        ratingEntity.setUserId(UtilityFunctions.getUserDto().id());
        repository.save(ratingEntity);
    }
        
}
