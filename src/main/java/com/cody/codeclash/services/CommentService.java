package com.cody.codeclash.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Comment;
import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.dtos.UserDto;
import com.cody.codeclash.repositories.CommentRepository;
import com.cody.codeclash.utils.UtilityFunctions;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    private final ProblemService problemService;

    public void save(Long problemId, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setProblem(problemService.getById(problemId));
        UserDto userDto = UtilityFunctions.getUserDto();
        comment.setUserId(userDto.id());
        repository.save(comment);
    }

    public void delete(Long problemId, Long id) {
        problemService.getById(problemId);
        repository.deleteById(id);
    }

    public void update(Long problemId, Long id, String content) {
        problemService.getById(problemId);
        getById(id);
        Comment comment = getById(id);
        comment.setContent(content);
        repository.save(comment);
    }

    public Comment getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found: " + id));
    }

    public List<Comment> getAllUserCommentsOnProblem
    (Long problemId) {
        Problem problem = problemService.getById(problemId);
        problem = new Problem().builder().id(problemId).build();

        return repository.findAllByProblemAndUserId(problem, UtilityFunctions.getUserDto().id());
    }


    public Page<Comment> getAllCommentsOnProblem(Long problemId, Pageable pageable) {
        Problem problem = problemService.getById(problemId);
  
        problem = Problem.builder().id(problemId).build();
        return repository.findAllByProblem(problem, pageable);
    }







}
