package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.ProblemDescription;
import com.cody.codeclash.repositories.DescriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemDescriptionService {

    public final DescriptionRepository repository;


    public void save(ProblemDescription description) {
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
     * @throws IllegalArgumentException if no problem description with the given id exists
     */
    public ProblemDescriptionDto getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Problem description not found"));

    }

    public void delete(ProblemDescription description) {
        
        getById(description.getId());
        repository.delete(description);
    }   





}
