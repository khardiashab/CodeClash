package com.cody.codeclash.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.Problem;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

}