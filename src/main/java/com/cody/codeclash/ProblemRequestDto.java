package com.cody.codeclash;

import java.util.Set;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.Tag;
import com.cody.codeclash.entities.enums.Difficulty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProblemRequestDto {

    private String title;

    private String difficulty;

    private Set<Tag> tags;

    public static Problem mapAProblem(ProblemRequestDto dto){

        return Problem.builder()
                    .title(dto.getTitle())
                    .difficulty(Difficulty.valueOf(dto.getDifficulty().toUpperCase()))
                    .tags(dto.getTags())
                    .build();
    }
}
