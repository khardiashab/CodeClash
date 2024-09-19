package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.ProblemDescription;
import com.cody.codeclash.entities.dtos.ProblemDescriptionDto;
import com.cody.codeclash.repositories.DescriptionRepository;
import com.cody.codeclash.repositories.ProblemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemDescriptionService {

    private final DescriptionRepository repository;

    private final ProblemRepository problemRepository;

    public void save(Long problemId, ProblemDescription description) {
        Problem problem = problemRepository.getReferenceById(problemId);
        description.setProblem(problem);
         repository.save(description);
    }

    public void update(ProblemDescription description) {
        getById(description.getId());
        repository.save(description);
    }

    /**
     * Gets a problem description by id.
     *
     * @param id the id of the problem description
     * @return the problem description with the given id
     * @throws IllegalArgumentException if no problem description with the given id
     *                                  exists
     */
    public ProblemDescriptionDto getDtoById(Long id) {
        ProblemDescription pd = getById(id);
        return ProblemDescriptionDto.from(pd);
    }

    public void delete(ProblemDescription description) {

        getById(description.getId());
        repository.delete(description);
    }

    private ProblemDescription getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Problem description not found"));
    }

}
