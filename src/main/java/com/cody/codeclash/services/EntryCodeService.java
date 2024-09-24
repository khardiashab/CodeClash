package com.cody.codeclash.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.dtos.EntryCodeDto;
import com.cody.codeclash.entities.enums.Language;
import com.cody.codeclash.repositories.EntryCodeRepository;
import com.cody.codeclash.utils.UtilityFunctions;
import com.cody.codeclash.utils.excepitons.EntryCodeAlreadyExistsException;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryCodeService {

    private final EntryCodeRepository repository;

    private final ProblemService problemService;

    public void create(Long problemId, EntryCodeDto entryCode) {
        problemService.validateProblemAndItsAuthor(problemId, UtilityFunctions.getUserDto().getId());

        /*
         * Validate uniqueness
         * We can have only one entry code with a specific language for a problem
         */
        validateEntryCodeUniqueness(problemId, entryCode.getLanguage());

        var entryCodeEntity = entryCode.toEntity();
        entryCodeEntity.setProblemId(problemId);
        repository.save(entryCodeEntity);
    }

    public void update(Long problemId, Long entryCodeId, EntryCodeDto entryCodeDto) {

        problemService.validateProblemAndItsAuthor(problemId, UtilityFunctions.getUserDto().getId());
        var entryCode = repository.findById(entryCodeId).orElseThrow();
        entryCode.setCode(entryCodeDto.getCode());
        if(!entryCodeDto.getLanguage().equals(entryCode.getLanguage())) {
            validateEntryCodeUniqueness(problemId, entryCodeDto.getLanguage());
        }
        entryCode.setLanguage(entryCodeDto.getLanguage());
        repository.save(entryCode);
    }


    public EntryCodeDto get(Long problemId, Long entryCodeId) {
        return EntryCodeDto.from(repository.findById(entryCodeId).orElseThrow( () -> new EntityNotFoundException("Entry code not found: " + entryCodeId)));
    }
    
    public List<EntryCodeDto> getAllOfAProblem(Long problemId) {
        return repository.findAllByProblemId(problemId).stream().map(EntryCodeDto::from).toList();
    }


    public void validateEntryCodeUniqueness(Long problemId, Language language) {


        if( repository.existsByProblemIdAndLanguage(problemId, language)) {
            throw new EntryCodeAlreadyExistsException("Entry code already exists in this language: " + language);
        }
        ;
    }
}
