package com.cody.codeclash.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class ProblemSocialInteraction {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Problem problem;    

    private Long likes;
    private Long dislikes;

    private Long saves;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Rating> ratings;

}
