package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Problem;
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

    

}
