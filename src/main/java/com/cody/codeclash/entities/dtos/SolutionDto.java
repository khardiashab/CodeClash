package com.cody.codeclash.entities.dtos;

import com.cody.codeclash.entities.Solution;
import com.cody.codeclash.entities.enums.Language;
import com.cody.codeclash.entities.enums.SolutionStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolutionDto {

    private Long id;
    private Long problemId;
    private SolutionStatus status;
    private String code;
    private Language language;
    private Long userId;

    public static Solution toEntity(SolutionDto solutionDto) {
        
       
        return Solution.builder()   
                .code(solutionDto.getCode())
                .language(solutionDto.getLanguage())
                .build();

    }



}
