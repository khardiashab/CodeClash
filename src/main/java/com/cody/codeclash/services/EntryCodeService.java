package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.dtos.EntryCodeDto;
import com.cody.codeclash.repositories.EntryCodeRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryCodeService {

    private final EntryCodeRepository repository;

    private final ProblemService problemService;

    public void create(Long problemId, EntryCodeDto entryCode) {
        problemService.validateProblemAndItsAuthor(problemId, UtilityFunctions.getUserDto().getId());

        var entryCodeEntity = entryCode.toEntity();
        entryCodeEntity.setProblemId(problemId);
        repository.save(entryCodeEntity);
    }
}
