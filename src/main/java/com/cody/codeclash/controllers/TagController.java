package com.cody.codeclash.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cody.codeclash.entities.dtos.TagDto;
import com.cody.codeclash.services.TagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @PostMapping("/")
    public void createTag(@RequestBody String name) {

        service.createTag(name);
    }

    @GetMapping("/")
    public List<TagDto> getAll() {
        return service.getAll();
    }
}
