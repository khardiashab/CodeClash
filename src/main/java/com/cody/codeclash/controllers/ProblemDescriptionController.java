package com.cody.codeclash.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.DescriptionRequestDto;
import com.cody.codeclash.services.ProblemDescriptionService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/problem-description")
@RequiredArgsConstructor
public class ProblemDescriptionController {

    private final ProblemDescriptionService service;
    
    @PostMapping("/{problemId}")
    public void create(@PathVariable Long problemId, @RequestBody DescriptionRequestDto description){
        service.save(problemId, description);
    }

    @PutMapping("/{problemId}")
    public void update (@PathVariable Long problemId, @RequestBody DescriptionRequestDto entity) {
        service.update(problemId, entity);
    }

}
