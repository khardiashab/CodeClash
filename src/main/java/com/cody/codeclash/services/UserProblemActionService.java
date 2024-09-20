package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.UserProblemAction;
import com.cody.codeclash.entities.UserProblemActionKey;
import com.cody.codeclash.entities.dtos.UserProblemActionDto;
import com.cody.codeclash.repositories.UserProblemActionRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProblemActionService {
    private final UserProblemActionRepository repository;

    public UserProblemActionDto getByProblemId(Long problemId) {
        UserProblemAction actions = repository.findById(getKey(problemId)).orElseThrow(() -> new EntityNotFoundException("User Problem Action not found: " + problemId));
        return UserProblemActionDto.from(actions);
    }

    public void validUserProblemActionExists(Long problemId) {
        if (!repository.existsById(getKey(problemId))) {
            throw new EntityNotFoundException("User Problem Action not found: " + problemId);
        }
    }

    private UserProblemActionKey getKey(Long problemId) {
        return new UserProblemActionKey(UtilityFunctions.getUserDto().id(), problemId);
    }

}
