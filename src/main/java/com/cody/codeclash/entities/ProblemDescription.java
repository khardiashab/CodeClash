package com.cody.codeclash.entities;

import lombok.Data;

import jakarta.persistence.*;
@Data
@Entity
public class ProblemDescription {

    @Id
    @Column(updatable = false, nullable = false, name = "id")
    private Long id;

    // how to define one to one relationship
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Problem problem;

    private String description;

    private String examples;

    private String constrains;

}


