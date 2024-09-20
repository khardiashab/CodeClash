package com.cody.codeclash.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.SolutionDto;
import com.cody.codeclash.entities.dtos.UserProblemActionDto;
import com.cody.codeclash.entities.enums.Reaction;
import com.cody.codeclash.services.UserProblemActionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/problems/{problemId}/user-actions")
@RequiredArgsConstructor
public class UserProblemActionController {

    private final UserProblemActionService service;

    @GetMapping("/")
    public UserProblemActionDto getUserActionOnAProblem(@PathVariable Long problemId) {
        return service.getByProblemId(problemId);
    }

    
    @PutMapping("/reaction")
    public void updateReaction(@PathVariable Long problemId, @RequestParam Reaction reaction) {
        service.updateReaction(problemId, reaction);
    }

    @PutMapping("/save-status")
    public void updateSaveStatus(@PathVariable Long problemId, @RequestParam boolean saveStatus) {
        service.updateSaveStatus(problemId, saveStatus);
    }

    @PostMapping("/run-test-case/{testCaseId}")
    public void runTestCase(@PathVariable Long problemId, @PathVariable Long testCaseId, @RequestBody SolutionDto solutionDto) {
        // TODO implement here service logic.
    }


    @PostMapping("/submit")
    public void submit(@PathVariable Long problemId, @RequestBody SolutionDto solutionDto) {
        // TODO implement here service logic.
    }

    
}
