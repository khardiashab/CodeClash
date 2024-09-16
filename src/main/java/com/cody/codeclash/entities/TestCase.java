package com.cody.codeclash.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TestCase {


    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inputType;
    private String input;
    private String outputType;
    private String output;
}
