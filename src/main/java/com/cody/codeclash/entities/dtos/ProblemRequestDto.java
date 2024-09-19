package com.cody.codeclash.entities.dtos;

import java.util.Set;

import com.cody.codeclash.entities.Tag;

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

}
