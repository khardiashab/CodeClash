package com.cody.codeclash.controllers;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.TestCaseDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/problems/{problemId}/testcases")
public class TestCaseController {


    @PostMapping("")
    public void create(@PathVariable Long problemId, @RequestBody TestCaseDto testCase) {
        // TODO implement here service logic.
    }

    @PutMapping("/{testCaseId}")
    public void update(@PathVariable Long problemId, @PathVariable Long testCaseId, @RequestBody TestCaseDto testCaseDto) {
        //TODO: process PUT request
        
    }

    @GetMapping("/{testCaseId}")
    public Test get(@PathVariable Long problemId, @PathVariable Long testCaseId) {
        //TODO: process GET request
        return null;
    }

    @PostMapping("/bulk")
    public void createInBulk(@PathVariable Long problemId, @RequestBody TestCaseDto[] testCase) {
        // TODO implement here service logic.
    }

    @GetMapping("")
    public List<Test> getAllOfAProblem(@PathVariable Long problemId) {
        //TODO: process GET request
        return null;
    }

    public List<Test> getFristThreeOFAProblem(@PathVariable Long problemId) {
        //TODO: process GET request
        return null;
    }

    @DeleteMapping("/{testCaseId}")
    public void delete(@PathVariable Long problemId, @PathVariable Long testCaseId) {
        //TODO: process DELETE request
    }

    

    
}
