package com.cody.codeclash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FullProblemRequest {

    private ProblemRequestDto problem;

    private ProblemDescriptionRequestDto description;

    private ProblemTestAndCodeRequestDto testAndCode;

}
