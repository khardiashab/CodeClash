package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.ProblemSocialInteraction;

@Repository 
public interface ProblemInteractionRepository  extends JpaRepository<ProblemSocialInteraction, Long> {

}
