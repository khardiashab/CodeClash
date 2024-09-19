package com.cody.codeclash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.Tag;
import com.cody.codeclash.entities.dtos.ProblemRequestDto;
import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.services.ProblemService;

@RestController
@RequestMapping("/api/problem")
public class ProblemController {

    @Autowired
    ProblemRepository repository;

    @Autowired
    ProblemService service;

    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @PostMapping("/")
    public void creatFullProblemDraft(@RequestBody ProblemRequestDto entity) {
        service.create(entity);
    }

    @PutMapping("/{problemId}/addtag")
    public void addTag(@PathVariable Long problemId, @RequestBody Tag tag) {
        service.addTag(problemId, tag);
    }

    @PutMapping("/{problemId}/removetag")
    public void removeTag(@PathVariable Long problemId, Tag tag){
        service.removeTag(problemId, tag);
    }

    @PutMapping("/{problemId}")
    public void update(@PathVariable Long problemId, @RequestBody ProblemRequestDto problem){
        service.update(problemId, problem);
    }


    @DeleteMapping("/{problemId}")
    public void delete(@PathVariable Long problemId)
    {
        service.delete(problemId);
    }

    


    

}
