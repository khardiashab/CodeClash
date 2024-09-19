package com.cody.codeclash.entities;

import java.util.Objects;

public class UserProblemActionKey implements java.io.Serializable {
    private Long userId;
    private Long problem;

    public UserProblemActionKey(Long userId, Long problem) {
        this.userId = userId;
        this.problem = problem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserProblemActionKey that = (UserProblemActionKey) o;
        return userId.equals(that.userId) && problem.equals(that.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, problem);
    }

}
