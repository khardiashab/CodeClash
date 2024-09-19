package com.cody.codeclash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.services.ProblemService;


@RestController
@RequestMapping("/api/problem")
public class ProblemController {

    @Autowired
    ProblemRepository repository;

    @Autowired 
    ProblemService  service;

    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @PostMapping("/")
    public void creatFullProblemDraft(@RequestBody FullProblemRequest entity) {

        service.createFullProblem(entity);



        

    }
    
    


    
}
