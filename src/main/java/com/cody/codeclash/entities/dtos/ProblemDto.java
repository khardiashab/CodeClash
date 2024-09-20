package com.cody.codeclash.entities.dtos;

import java.util.List;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.enums.Difficulty;

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
public class ProblemDto {

    private Long id;
    private String title;
    private Difficulty difficulty;
    private List<TagDto> tags;
    private Long authorId;
    private String authorName;

    public static ProblemDto from(Problem problem) {
        return ProblemDto.builder()
                .id(problem.getId())
                .title(problem.getTitle())
                .difficulty(problem.getDifficulty())
                .tags((problem.getTags().stream().map(TagDto::from).toList()))
                .authorId(problem.getAuthorId())
                .authorName(problem.getAuthorName())
                .build();
    }
}
