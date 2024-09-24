package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.dtos.TestCaseDto;
import com.cody.codeclash.repositories.TestCaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public  class TestCaseService {

    private final TestCaseRepository repository;

    public void create(Long problemId, TestCaseDto testCaseDto) {

    }
    
}
