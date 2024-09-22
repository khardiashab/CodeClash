package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    boolean existsByIdAndAuthorId(Long problemId, Long authorId);
    
}