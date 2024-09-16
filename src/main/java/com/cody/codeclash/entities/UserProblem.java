package com.cody.codeclash.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class UserProblem {



    @EmbeddedId

    private User user;

    private Problem problem;

    private Enum reaction;

    private boolean saved;

}
