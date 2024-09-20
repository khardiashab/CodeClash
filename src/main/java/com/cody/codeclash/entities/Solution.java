package com.cody.codeclash.entities;

import com.cody.codeclash.entities.enums.Language;
import com.cody.codeclash.entities.enums.SolutionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Language language;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;    

    private SolutionStatus status;

    private Long userId;

}
