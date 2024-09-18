package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Rating;
import com.cody.codeclash.repositories.RatingRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository repository;

    private final ProblemService problemService;

    public void save(Long problemId, int rating) {
        var problem = problemService.getById(problemId);
        var ratingEntity = Rating.builder()
                .score(rating)
                .problem(problem)
                .userId(UtilityFunctions.getUserDto().id())
                .build();
        repository.save(ratingEntity);
    }

    public int getAvgUserRatingOnAProblem(Long problemId) {
        var problem = problemService.getById(problemId);
        var ratings = repository.findAllByProblem(problem);
        return ratings.stream()
                .mapToInt(Rating::getScore)
                .sum() / ratings.size();
    }

    public Rating getUserRatingOnProblem(Long problemId) {
        return repository.findByProblemAndUserId(problemService.getById(problemId), UtilityFunctions.getUserDto().id())
                .orElseThrow(() -> new EntityNotFoundException("Rating not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
