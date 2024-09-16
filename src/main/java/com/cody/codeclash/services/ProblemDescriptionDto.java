package com.cody.codeclash.services;

import java.util.List;

public record ProblemDescriptionDto(

    Long id,
    String description,
List<ExampleDto> examples,
    List<String> constraints
) {
} 
