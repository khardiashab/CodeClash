package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.repositories.ProblemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository repository;
    

    

}
