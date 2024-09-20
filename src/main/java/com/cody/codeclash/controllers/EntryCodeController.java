package com.cody.codeclash.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.EntryCodeDto;

@RestController
@RequestMapping("/api/problems/{problemId}/entrycodes")
public class EntryCodeController {

    @PostMapping("/")
    public void create(@PathVariable Long problemId, @RequestBody EntryCodeDto entryCode) {
        // TODO implement here service logic.
    }

    @PutMapping("/{entryCodeId}")
    public void update(@PathVariable Long problemId, @PathVariable Long entryCodeId, @RequestBody EntryCodeDto entryCodeDto) {
        // TODO implement here service logic.
    }

    @GetMapping("/{entryCodeId}")
    public EntryCodeDto get(@PathVariable Long problemId, @PathVariable Long entryCodeId) {
        // TODO implement here service logic.
        return null;
    }

    @GetMapping("")
    public List<EntryCodeDto> getAllOfAProblem(@PathVariable Long problemId) {
        // TODO implement here service logic.
        return null;
    }
}
