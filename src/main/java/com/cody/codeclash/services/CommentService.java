package com.cody.codeclash.services;

import org.springframework.stereotype.Service;

import com.cody.codeclash.entities.Comment;
import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.User;
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
    public Comment save(Long problemId, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setProblem(problemService.getById(problemId));
        UserDto userDto = UtilityFunctions.getUserDto();
        User user = new User();
        user.setId(userDto.id());
        comment.setUser( user);
        return repository.save(comment);
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
        







}
