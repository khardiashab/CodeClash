package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.UserProblemAction;
import com.cody.codeclash.entities.UserProblemActionKey;
import com.cody.codeclash.entities.dtos.UserProblemActionDto;
import com.cody.codeclash.entities.enums.Reaction;
import com.cody.codeclash.repositories.UserProblemActionRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProblemActionService {

    private final UserProblemActionRepository repository;

    private final ProblemInteractionService problemInteractionService;

    public UserProblemActionDto getByProblemId(Long problemId) {
        UserProblemAction action = getById(UtilityFunctions.getUserDto().id(), problemId);
        return UserProblemActionDto.from(action);
    }

    // -------------- update status ----------------------
    @Transactional
    public void updateReaction(Long problemId, Reaction reaction) {
        var action = getById(UtilityFunctions.getUserDto().id(), problemId);
        if (action.getReaction() == reaction) {
            throw new RuntimeException("Your reaction is already " + action.getReaction());
        }
        if (reaction == Reaction.LIKE) {
            if (action.getReaction() == Reaction.DISLIKE)
                problemInteractionService.decreaseDislikes(problemId);
            problemInteractionService.increaseLikes(problemId);
        }
        if (reaction == Reaction.DISLIKE) {
            if (action.getReaction() == Reaction.LIKE)
                problemInteractionService.decreaseLikes(problemId);
            problemInteractionService.increaseDislikes(problemId);
        }
        if (reaction == Reaction.NONE) {
            if (action.getReaction() == Reaction.LIKE)
                problemInteractionService.decreaseLikes(problemId);
            if (action.getReaction() == Reaction.DISLIKE)
                problemInteractionService.decreaseDislikes(problemId);
        }

        action.setReaction(reaction);
        repository.save(action);
    }

    @Transactional
    public void updateSaveStatus(Long problemId, boolean saveStatus) {
        var action = getById(UtilityFunctions.getUserDto().id(), problemId);
        if (action.isSaved() == saveStatus) {
            throw new RuntimeException("Your save status is already " + action.isSaved());
        }
        if (saveStatus) {
            problemInteractionService.increaseSaves(problemId);
        } else {
            problemInteractionService.decreaseSaves(problemId);
        }
        action.setSaved(saveStatus);
        repository.save(action);
    }

    public void setSolvedTrue(Long problemId) {
        var action = getById(UtilityFunctions.getUserDto().id(), problemId);
        action.setSolved(true);
        repository.save(action);
    }

    public void validUserProblemActionExists(Long problemId) {
        if (!repository.existsById(getKey(problemId))) {
            throw new EntityNotFoundException("User Problem Action not found: " + problemId);
        }
    }

    public UserProblemAction getById(Long userId, Long problemId) {
        return repository.findById(getKey(problemId))
                .orElseThrow(() -> new EntityNotFoundException("User Problem Action not found: " + problemId));

    }

    private UserProblemActionKey getKey(Long problemId) {
        return new UserProblemActionKey(UtilityFunctions.getUserDto().id(), problemId);
    }

}
