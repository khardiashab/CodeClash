package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.ProblemSocialInteraction;
import com.cody.codeclash.repositories.ProblemInteractionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProblemInteractionService {

    private final ProblemInteractionRepository repository;

    
    public void save(ProblemSocialInteraction interaction) {
        repository.save(interaction);
    }

    public void update(ProblemSocialInteraction interaction) {
        repository.save(interaction);
    }

    
    public ProblemSocialInteraction getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void increaseLikes(Long id) {
        ProblemSocialInteraction interaction = repository.findById(id).orElse(null);
        if (interaction != null) {
            interaction.setLikes(interaction.getLikes() + 1);
            repository.save(interaction);
        } else {
            throw new IllegalArgumentException("Interaction not found");
        }
    }

    public void increaseDislikes(Long id) {
        ProblemSocialInteraction interaction = repository.findById(id).orElse(null);
        if (interaction != null) {
            interaction.setDislikes(interaction.getDislikes() + 1);
            repository.save(interaction);
        } else {
            throw new IllegalArgumentException("Interaction not found");
        }
    }

    public void increaseSaves(Long id) {
        ProblemSocialInteraction interaction = repository.findById(id).orElse(null);
        if (interaction != null) {
            interaction.setSaves(interaction.getSaves() + 1);
            repository.save(interaction);
        } else {
            throw new IllegalArgumentException("Interaction not found");
        }
    }

    public void decreaseLikes(Long id) {
        ProblemSocialInteraction interaction = repository.findById(id).orElse(null);
        if (interaction != null) {
            interaction.setLikes(interaction.getLikes() - 1);
            repository.save(interaction);
        } else {
            throw new IllegalArgumentException("Interaction not found");
        }
    }

    public void decreaseDislikes(Long id) {
        ProblemSocialInteraction interaction = repository.findById(id).orElse(null);
        if (interaction != null) {
            interaction.setDislikes(interaction.getDislikes() - 1);
            repository.save(interaction);
        } else {
            throw new IllegalArgumentException("Interaction not found");
        }
    }

    public void decreaseSaves(Long id) {
        ProblemSocialInteraction interaction = repository.findById(id).orElse(null);
        if (interaction != null) {
            interaction.setSaves(interaction.getSaves() - 1);
            repository.save(interaction);
        } else {
            throw new IllegalArgumentException("Interaction not found");
        }
    }







}
