package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.TestCase;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

}
