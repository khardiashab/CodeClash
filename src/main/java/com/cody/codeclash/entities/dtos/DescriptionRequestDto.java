package com.cody.codeclash.entities.dtos;

import java.util.*;

import com.cody.codeclash.entities.ProblemDescription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder                  
public class DescriptionRequestDto {

    private String description;

    private String examples;

    private List<String> constraints;

    private String timeComplexity;

    private String spaceComplexity;

    public ProblemDescription toEntity() {
        return ProblemDescription.builder()
                .description(description)
                .examples(examples)
                .constraints(constraints)
                .timeComplexity(timeComplexity)
                .spaceComplexity(spaceComplexity)
                .build();
    }

    public static DescriptionRequestDto from(ProblemDescription description) {
        return DescriptionRequestDto.builder()
                .description(description.getDescription())
                .examples(description.getExamples())
                .constraints(description.getConstraints())
                .timeComplexity(description.getTimeComplexity())
                .spaceComplexity(description.getSpaceComplexity())
                .build();
    }

}
