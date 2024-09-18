package com.cody.codeclash.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.Comment;
import com.cody.codeclash.entities.Problem;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProblemAndUserId(Problem problem, Long userId);

    Page<Comment> findAllByProblem(Problem problem, Pageable pageable);

}
