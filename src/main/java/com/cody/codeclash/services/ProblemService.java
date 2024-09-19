package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.FullProblemRequest;
import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.ProblemDescription;
import com.cody.codeclash.repositories.ProblemRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository repository;



    Problem getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Problem not found: " + id));
    }



    public void validUserProblemActionExists(Long problemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validUserProblemActionExists'");
    }

    public void save(Problem problem) {
        repository.save(problem);
     */
    }

    public void saveFullProblem(Problem problem, ProblemDescription description) {

    

}



    public void createFullProblem(FullProblemRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createFullProblem'");
    }
