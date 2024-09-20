package com.cody.codeclash.entities.dtos;

import com.cody.codeclash.entities.Tag;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TagDto {

    private Long id;

    private String name;

    public static TagDto from(Tag tag) {
        return new TagDto(tag.getId(), tag.getName());
    }

}
