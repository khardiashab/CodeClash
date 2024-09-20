package com.cody.codeclash.entities.dtos;

import java.util.List;

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
public class DescriptionDto {

    private Long problemId;

    private String description;

    private String examples;

    private List<String> constraints;

    private String timeComplexity;

    private String spaceComplexity;

    /**
     * Converts this DTO to a ProblemDescription entity.
     * It will used to create a new ProblemDescription entity.
     * 
     * @return a new ProblemDescription entity with the same state as this DTO.
     */
    public ProblemDescription toEntity() {
        return ProblemDescription.builder()
                .description(description)
                .examples(examples)
                .constraints(constraints)
                .timeComplexity(timeComplexity)
                .spaceComplexity(spaceComplexity)
                .build();
    }

    public static DescriptionDto from(ProblemDescription description) {
        return DescriptionDto.builder()
                .problemId(description.getProblem().getId())
                .description(description.getDescription())
                .examples(description.getExamples())
                .constraints(description.getConstraints())
                .timeComplexity(description.getTimeComplexity())
                .spaceComplexity(description.getSpaceComplexity())
                .build();
    }

}
