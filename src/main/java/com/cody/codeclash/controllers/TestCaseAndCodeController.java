package com.cody.codeclash.controllers;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.EntryCodeRequestDto;
import com.cody.codeclash.entities.dtos.TestCaseRequestDto;
import com.cody.codeclash.services.TestCaseAndCodeService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/problems/{problemId}")
@RequiredArgsConstructor
public class TestCaseAndCodeController {

    private final TestCaseAndCodeService service;                

    // Add a test case to the problem 
    @PostMapping("/testcase")
    public void addATestCases(@PathVariable Long problemId, @RequestBody TestCaseRequestDto[] testCases) {

        service.addTestCases(problemId, testCases);
     

    }
    // Add a test case to the problem 
    @PostMapping("/entrycode")
    public void addEntryCodes(@PathVariable Long problemId, @RequestBody EntryCodeRequestDto[] entryCodes) {
     
        service.addEntryCodes(problemId, entryCodes);
    }
    // Add a test case to the problem 
    @DeleteMapping("/entrycode/{entryCodeId}")
    public void removeEntryCode(@PathVariable Long problemId, @PathVariable Long entryCodeId) {

        service.removeEntryCode(problemId, entryCodeId); 
     

    }

    @DeleteMapping("/testcase/{testCaseId}")
    public void removeATestCase(@PathVariable Long problemId, @PathVariable Long testCaseId) {
        service.removeATestCase(problemId, testCaseId);

    }

}
