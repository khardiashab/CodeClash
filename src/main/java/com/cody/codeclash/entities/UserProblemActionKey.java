package com.cody.codeclash.entities;

import java.util.Objects;

public class UserProblemActionKey implements java.io.Serializable {
    private Long userId;
    private Long problemId;

    public UserProblemActionKey(Long userId, Long problemId) {
        this.userId = userId;
        this.problemId = problemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserProblemActionKey that = (UserProblemActionKey) o;
        return userId.equals(that.userId) && problemId.equals(that.problemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, problemId);
    }

}
