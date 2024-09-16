package com.cody.codeclash.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.Tag;
import com.cody.codeclash.repositories.TagRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TagService {

    public final TagRepository repository;

    public void save(Tag tag) {
        repository.save(tag);
    }

    public void delete(Tag tag) {
        repository.delete(tag);
    }

    public Tag getById(Long id) {    
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tag not found"));
    }

    public List<Tag> getAll() {
        return repository.findAll();
    }

    public Tag getByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Tag not found"));
    }
}
