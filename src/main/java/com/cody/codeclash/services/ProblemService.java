package com.cody.codeclash.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.ProblemDescription;
import com.cody.codeclash.entities.ProblemSocialInteraction;
import com.cody.codeclash.entities.ProblemTestCaseAndCode;
import com.cody.codeclash.entities.Tag;
import com.cody.codeclash.entities.dtos.ProblemDto;
import com.cody.codeclash.entities.dtos.ProblemRequestDto;
import com.cody.codeclash.entities.enums.Difficulty;
import com.cody.codeclash.entities.enums.Language;
import com.cody.codeclash.entities.enums.Status;
import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository repository;

    private final ProblemInteractionService interactionService;

    // ----------Create and Update method ---------------------
    public void create(ProblemRequestDto dto) {
        var problem = Problem.builder()
                .title(dto.getTitle())
                .difficulty(null != dto.getDifficulty() ? Difficulty.valueOf(dto.getDifficulty().toUpperCase()) : null)
                .tags(null != dto.getTags() ? dto.getTags() : null)
                .status(Status.DRAFT)
                .authorId(UtilityFunctions.getUserDto().id())
                .authorName(UtilityFunctions.getUserDto().username())
                .build();
        repository.save(problem);
    }

    public void addTag(Long problemId, Tag tag) {
        Problem problem = getById(problemId);
        validateProblemAuthor(problem);
        problem.addTag(tag);
        repository.save(problem);
    }

    public void removeTag(Long problemId, Tag tag) {
        var problem = getById(problemId);
        validateProblemAuthor(problem);

        problem.removeTag(tag);
    }

    public void update(Long problemId, ProblemRequestDto problemdto) {
        var problem = getById(problemId);
        validateProblemAuthor(problem);

        problem.setTitle(problemdto.getTitle());
        problem.setTags(problemdto.getTags());
        problem.setDifficulty(Difficulty.valueOf(problemdto.getDifficulty().toUpperCase()));

        repository.save(problem);
    }

    // ------------------------delete method -------
    public void delete(Long problemId) {
        var problem = getById(problemId);
        validateProblemAuthor(problem);
        repository.deleteById(problem.getId());
        // if neccessary then delete all related info.
    }

    // -----------------------------
    public Problem getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Problem not found: " + id));
    }

    // Publish a problem

    @Transactional
    public void publish(Long problemId) {
        var problem = getById(problemId);
        validateProblemAuthor(problem);
        ProblemDescription pd = problem.getDescription();
        if (null == pd) {
            throw new RuntimeException("Problem description is not set.");
        }
        ProblemTestCaseAndCode testCaseAndCode = problem.getTestCaseAndCode();
        if (null == testCaseAndCode) {
            throw new RuntimeException("Problem testcase and code is not set.");
        }
        if (testCaseAndCode.getEntryCodes().size() != Language.values().length) {
            throw new RuntimeException("You have not set the entry code for all languages.");
        }

        if (testCaseAndCode.getTestCases().size() < 3) {
            throw new RuntimeException("You have not set at least 3 test cases.");
        }
        // Add problem interation table here.
        ProblemSocialInteraction ps = new ProblemSocialInteraction();
        ps.setProblem(Problem.builder().id(problemId).build());
        interactionService.save(ps);
    
        problem.setStatus(Status.PUBLISHED);
        problem.setDescription(null);
        problem.setTestCaseAndCode(null);
        repository.save(problem);

    }

    // Get all problems 
    public List<ProblemDto> getAll() {
        return repository.findAll().stream().map(ProblemDto::from).toList();
    }

    // Helping function to stop repetative code

    public void validateProblemAuthor(Problem problem) {
        if (problem.getAuthorId() != UtilityFunctions.getUserDto().id()) {
            throw new RuntimeException("You are not author of this problem with Title: " + problem.getTitle());
        }
    }

}
