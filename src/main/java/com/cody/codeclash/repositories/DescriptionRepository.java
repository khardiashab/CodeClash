package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.ProblemDescription;

@Repository
public interface DescriptionRepository extends JpaRepository<ProblemDescription, Long> {


}
