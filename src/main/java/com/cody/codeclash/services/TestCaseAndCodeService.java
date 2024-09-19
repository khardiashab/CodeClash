package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.repositories.TestCaseAndCodeRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestCaseAndCodeService {

    private final TestCaseAndCodeRepository repository;

    public void save(Long problemId, TestCaseAndCodeDto dto) {
        
    }
}
