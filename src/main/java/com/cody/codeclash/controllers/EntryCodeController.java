package com.cody.codeclash.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.EntryCodeDto;
import com.cody.codeclash.services.EntryCodeService;

@RestController
@RequestMapping("/api/problems/{problemId}/entrycodes")
public class EntryCodeController {

    @Autowired
    private EntryCodeService service;
    @PostMapping("/")
    public void create(@PathVariable Long problemId, @RequestBody EntryCodeDto entryCode) {
        service.create(problemId, entryCode);
    }

    @PutMapping("/{entryCodeId}")
    public void update(@PathVariable Long problemId, @PathVariable Long entryCodeId, @RequestBody EntryCodeDto entryCodeDto) {
        service.update(problemId, entryCodeId, entryCodeDto);
    }

    @GetMapping("/{entryCodeId}")
    public EntryCodeDto get(@PathVariable Long problemId, @PathVariable Long entryCodeId) {
        return service.get(problemId, entryCodeId);
    }

    @GetMapping("")
    public List<EntryCodeDto> getAllOfAProblem(@PathVariable Long problemId) {
        return service.getAllOfAProblem(problemId);
    }
}
