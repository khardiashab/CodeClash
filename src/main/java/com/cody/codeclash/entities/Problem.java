package com.cody.codeclash.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private Difficulty difficulty;


    @ManyToMany(mappedBy = "problems")
    private Set<Tag> tags;

    @OneToOne(fetch = FetchType.LAZY)
    private ProblemDescription description;

    @OneToOne(fetch = FetchType.LAZY)
    private ProblemSocialInteraction interaction;

    @CreationTimestamp
    private Date dateCreated;
 
    @UpdateTimestamp
    private Date updatedAt;



    
    

}
