package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Rating;
import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.repositories.RatingRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository repository;

    private final ProblemService problemService;

    private final ProblemRepository problemRepository;

    public void save(Long problemId, int rating) {
        var ratingEntity = Rating.builder()
                .score(rating)
                .problem(problemRepository.getReferenceById(problemId))
                .userId(UtilityFunctions.getUserDto().id())
                .build();
        repository.save(ratingEntity);
    }

    public int getAvgUserRatingOnAProblem(Long problemId) {
        var ratings = repository.findAllByProblem(problemRepository.getReferenceById(problemId));
        return ratings.stream()
                .mapToInt(Rating::getScore)
                .sum() / ratings.size();
    }

    public Rating getUserRatingOnProblem(Long problemId) {
        return repository.findByProblemAndUserId(problemRepository.getReferenceById(problemId), UtilityFunctions.getUserDto().id());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
