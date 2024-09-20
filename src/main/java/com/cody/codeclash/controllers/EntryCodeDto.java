package com.cody.codeclash.controllers;

import com.cody.codeclash.entities.EntryCode;
import com.cody.codeclash.entities.enums.Language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntryCodeDto {

    private Long id;

    private Long problemId;

    private String code;

    private Language language;

    public static EntryCodeDto from(EntryCode entryCode) {
        return EntryCodeDto.builder()
                .id(entryCode.getId())
                .problemId(entryCode.getProblemId())
                .code(entryCode.getCode())
                .language(entryCode.getLanguage())
                .build();
    }

    public EntryCode toEntity() {
        return EntryCode.builder()
                .code(code)
                .language(language)
                .build();
    }

}
