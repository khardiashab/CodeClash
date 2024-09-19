package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.ProblemRequestDto;
import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.Tag;
import com.cody.codeclash.entities.enums.Difficulty;
import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository repository;

    // ----------Create and Update method ---------------------
    public void create(ProblemRequestDto dto) {
        var problem = Problem.builder()
                .title(dto.getTitle())
                .difficulty(null != dto.getDifficulty() ? Difficulty.valueOf(dto.getDifficulty().toUpperCase()) : null)
                .tags(null != dto.getTags() ? dto.getTags() : null)
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

    // Helping function to stop repetative code

    public void validateProblemAuthor(Problem problem) {
        if (problem.getId() != UtilityFunctions.getUserDto().id()) {
            throw new RuntimeException("You are not author of this problem with Title: " + problem.getTitle());
        }
    }

}
