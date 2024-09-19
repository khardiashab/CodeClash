package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.dtos.DescriptionRequestDto;
import com.cody.codeclash.repositories.DescriptionRepository;
import com.cody.codeclash.repositories.ProblemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemDescriptionService {

    private final DescriptionRepository repository;

    private final ProblemRepository problemRepository;

    private final ProblemService problemService;           
    public void save(Long problemId, DescriptionRequestDto descriptiondDto) {
        Problem problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);
        if(repository.existsById(problemId)){
            throw new RuntimeException("Description already exists for problem: " + problemId);
        }
        var description = descriptiondDto.toEntity();
        description.setProblem(Problem.builder().id(problemId).build());
         repository.save(description);
    }


    public void update(Long problemId, DescriptionRequestDto descriptiondDto) {
        var description = repository.getReferenceById(problemId);
        description.setDescription(descriptiondDto.getDescription());
        description.setExamples(descriptiondDto.getExamples());
        description.setConstraints(descriptiondDto.getConstraints());
        description.setTimeComplexity(descriptiondDto.getTimeComplexity());
        description.setSpaceComplexity(descriptiondDto.getSpaceComplexity());
        repository.save(description);
    }

    
}
