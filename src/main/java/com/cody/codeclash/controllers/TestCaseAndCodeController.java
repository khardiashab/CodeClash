package com.cody.codeclash.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.TestCaseAndCodeDto;
import com.cody.codeclash.services.TestCaseAndCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test-case-and-code")
@RequiredArgsConstructor
public class TestCaseAndCodeController {

    private final TestCaseAndCodeService service;

    @PostMapping("/{problemId}")
    public void create(@PathVariable Long problemId, @RequestBody TestCaseAndCodeDto dto) {
        service.save(problemId, dto);
    }
}
