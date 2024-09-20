package com.cody.codeclash.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.DescriptionDto;
import com.cody.codeclash.services.ProblemDescriptionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/problem-description")
@RequiredArgsConstructor
public class ProblemDescriptionController {

    private final ProblemDescriptionService service;

    @PostMapping("/{problemId}")
    public void create(@PathVariable Long problemId, @RequestBody DescriptionDto description) {
        service.save(problemId, description);
    }

    @PutMapping("/{problemId}")
    public void update(@PathVariable Long problemId, @RequestBody DescriptionDto entity) {
        service.update(problemId, entity);
    }

    @GetMapping("/{problemId}")
    public DescriptionDto get(@PathVariable Long problemId) {
        return service.get(problemId);
    }

}
