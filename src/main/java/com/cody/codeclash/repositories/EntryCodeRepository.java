package com.cody.codeclash.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.EntryCode;
import com.cody.codeclash.entities.enums.Language;

@Repository
public interface EntryCodeRepository extends JpaRepository<EntryCode, Long> {

    boolean existsByProblemIdAndLanguage(Long problemId, Language language);

    Optional<EntryCode> findAllByProblemId(Long problemId);

}
