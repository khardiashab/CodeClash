package com.cody.codeclash.entities;

import java.util.Set;

import com.cody.codeclash.entities.enums.Difficulty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private Difficulty difficulty;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @OneToOne(fetch = FetchType.LAZY)
    private ProblemDescription description;

    @OneToOne(fetch = FetchType.LAZY)
    private ProblemSocialInteraction interaction;

}
