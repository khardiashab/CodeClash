package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.dtos.DescriptionDto;
import com.cody.codeclash.repositories.DescriptionRepository;
import com.cody.codeclash.repositories.ProblemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemDescriptionService {

    private final DescriptionRepository repository;

    private final ProblemRepository problemRepository;

    private final ProblemService problemService;

    public void save(Long problemId, DescriptionDto descriptiondDto) {
        Problem problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);
        if (repository.existsById(problemId)) {
            throw new RuntimeException("Description already exists for problem: " + problemId);
        }
        var description = descriptiondDto.toEntity();
        description.setProblem(Problem.builder().id(problemId).build());
        repository.save(description);
    }

    public void update(Long problemId, DescriptionDto descriptiondDto) {
        // validate the problem is present
        var problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);
        // validate the description is present
        if(!repository.existsById(problemId)) {
            throw new RuntimeException("Description not found for problem: " + problemId);
        }
        var description = descriptiondDto.toEntity();
        description.setProblem(Problem.builder().id(problemId).build());
        repository.save(description);
    }


    // get problem description
    public DescriptionDto get(Long problemId) {
        var description = repository.getReferenceById(problemId);
        return DescriptionDto.from(description);
    }
}
