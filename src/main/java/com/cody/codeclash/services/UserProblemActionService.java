package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.UserProblemAction;
import com.cody.codeclash.entities.UserProblemActionKey;
import com.cody.codeclash.entities.enums.Reaction;
import com.cody.codeclash.repositories.UserProblemActionRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProblemActionService {
    private final UserProblemActionRepository repository;

    public UserProblemAction getById(Long problemId){


        return repository.findById(getKey(problemId)).orElse(null);
    }


    public void validUserProblemActionExists(Long problemId) {
        if (!repository.existsById(getKey(problemId))) {
            throw new EntityNotFoundException("User Problem Action not found: " + problemId);
        }
    }

    public void createWithDefaultValues(Long problemId) {
        var userProblemAction = UserProblemAction.builder()
        .id(getKey(problemId))
        .reaction(Reaction.NONE)
        .saved(false)
        .build();
        repository.save(userProblemAction); 
    
    }

   private UserProblemActionKey getKey(Long problemId){
        return new UserProblemActionKey(UtilityFunctions.getUserDto().id(), problemId);
    }




}
