package com.cody.codeclash.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    

    public Optional<Tag> findByName(String name);
}
