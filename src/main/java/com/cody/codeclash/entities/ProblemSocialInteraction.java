package com.cody.codeclash.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class ProblemSocialInteraction {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Problem problem;    

    private Long likes;
    private Long dislikes;

    private Long saves;

    private List<Comment> comments;

    private List<Rating> ratings;

}
