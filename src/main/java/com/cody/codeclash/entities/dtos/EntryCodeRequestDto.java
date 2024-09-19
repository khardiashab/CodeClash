package com.cody.codeclash.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EntryCodeRequestDto {

    private String language;
    private String code;
    

}
