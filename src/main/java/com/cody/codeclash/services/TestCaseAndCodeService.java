package com.cody.codeclash.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.EntryCode;
import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.ProblemTestCaseAndCode;
import com.cody.codeclash.entities.TestCase;
import com.cody.codeclash.entities.dtos.EntryCodeRequestDto;
import com.cody.codeclash.entities.dtos.TestCaseRequestDto;
import com.cody.codeclash.entities.enums.Language;
import com.cody.codeclash.repositories.EntryCodeRepository;
import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.repositories.TestCaseAndCodeRepository;
import com.cody.codeclash.repositories.TestCaseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestCaseAndCodeService {

    private final TestCaseAndCodeRepository repository;

    private final ProblemRepository problemRepository;

    private final ProblemService problemService; 

    private final TestCaseRepository testCaseRepository;

    private final EntryCodeRepository entryCodeRepository;

    public void addTestCases(Long problemId, TestCaseRequestDto[] testCases) {

        Problem problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);

        ProblemTestCaseAndCode testCaseAndCode;

        Optional<ProblemTestCaseAndCode> optional = repository.findById(problemId);

        if(optional.isPresent()) testCaseAndCode = optional.get();
        else testCaseAndCode = new ProblemTestCaseAndCode();

        for(TestCaseRequestDto testCase : testCases) {
           var test = TestCase.builder()
                    .input(testCase.getInput())
                    .expectedOutput(testCase.getExpectedOutput())
                    .problemId(problemId)
                    .build();

            testCaseAndCode.addTestCase(test);
        
        }

        repository.save(testCaseAndCode);


    }

    public void removeATestCase(Long problemId, Long testCaseId) {

        Problem problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);

        var testCase = testCaseRepository.findById(testCaseId).orElseThrow(
            () -> new EntityNotFoundException("Test case not found: " + testCaseId)
        );


        Optional<ProblemTestCaseAndCode> optional = repository.findById(problemId);
        if(optional.isPresent()) {
            ProblemTestCaseAndCode testCaseAndCode = optional.get();
          testCaseAndCode.removeTestCase(testCase);
          repository.save(testCaseAndCode);
        }

    }

    
	public void addEntryCodes(Long problemId, EntryCodeRequestDto[] entryCodes) {

        Problem problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);

        ProblemTestCaseAndCode testCaseAndCode;
        Optional<ProblemTestCaseAndCode> optional = repository.findById(problemId);

        if(optional.isPresent()) testCaseAndCode = optional.get();
        else testCaseAndCode = new ProblemTestCaseAndCode();

        for(EntryCodeRequestDto entryCode : entryCodes) {

            var entry = EntryCode.builder()
                .code(entryCode.getCode())
                .language(Language.valueOf(entryCode.getLanguage().toUpperCase()))
                .problemId(problemId)
                .build();
            testCaseAndCode.addEntryCode(entry);
        }

        repository.save(testCaseAndCode);

	}
    public void removeEntryCode(Long problemId, Long entryCodeId) {

        Problem problem = problemService.getById(problemId);
        problemService.validateProblemAuthor(problem);

        var entryCode = entryCodeRepository.findById(entryCodeId).orElseThrow(
            () -> new EntityNotFoundException("Entry code not found: " + entryCodeId)
        );

        Optional<ProblemTestCaseAndCode> optional = repository.findById(problemId);
        if(optional.isPresent()) {
            ProblemTestCaseAndCode testCaseAndCode = optional.get();
          testCaseAndCode.removeEntryCode(entryCode);
          repository.save(testCaseAndCode);
        }
    }

}
