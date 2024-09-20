package com.cody.codeclash.entities.dtos;

import lombok.*;

import com.cody.codeclash.entities.TestCase;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestCaseDto {

    private Long id;
    private Long problemId;
    private String input;
    private String expectedOutput;

    
    public static TestCaseDto from(TestCase testCase) {
        return new TestCaseDto(testCase.getId(), testCase.getProblemId(), testCase.getInput(), testCase.getExpectedOutput());
    }

    
    public TestCase toEntity() {
        return TestCase.builder()
                    .input(input)
                    .expectedOutput(expectedOutput)
                    .build();
    }
}
