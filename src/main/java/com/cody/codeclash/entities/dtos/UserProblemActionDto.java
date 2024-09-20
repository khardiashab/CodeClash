package com.cody.codeclash.entities.dtos;

import com.cody.codeclash.entities.UserProblemAction;
import com.cody.codeclash.entities.enums.Reaction;
import com.cody.codeclash.entities.enums.SolutionStatus;
import com.cody.codeclash.entities.enums.Status;

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
public class UserProblemActionDto {

    private Long problemId;
    private Long userId;
    private Reaction reaction;
    private boolean saved;
    private boolean solved;

    public static UserProblemActionDto from(UserProblemAction userProblemAction) {
        return UserProblemActionDto.builder()
                .problemId(userProblemAction.getProblemId())
                .userId(userProblemAction.getUserId())
                .reaction(userProblemAction.getReaction())
                .saved(userProblemAction.isSaved())
                .solved(userProblemAction.isSaved())
                .build();
    }
}
