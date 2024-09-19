package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.ProblemTestCaseAndCode;

@Repository
public interface TestCaseAndCodeRepository extends JpaRepository<ProblemTestCaseAndCode, Long> {


}
