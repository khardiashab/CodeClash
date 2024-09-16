package com.cody.codeclash.entities.dtos;

import java.util.List;

import com.cody.codeclash.entities.ProblemDescription;

public record ProblemDescriptionDto(

    Long id,
    String description,
List<ExampleDto> examples,
    List<String> constraints
) {
    public static ProblemDescriptionDto from(ProblemDescription description) {
        //  convert ProblemDescription to ProblemDescriptionDto
       return new ProblemDescriptionDto(

           description.getId(),
           description.getDescription(),
           List.of(ExampleDto.from(description.getExamples())),
           description.getConstraints()
       );
    }
} 
