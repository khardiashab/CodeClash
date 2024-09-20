package com.cody.codeclash.entities;

import java.util.Objects;

import com.cody.codeclash.entities.enums.Reaction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@IdClass(UserProblemActionKey.class)
public class UserProblemAction {

    @Id // Maps the userId from the composite key to this field
    private Long userId;

    @Id
    private Long problemId;
    private Reaction reaction;

    private boolean saved;

    private boolean solved;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserProblemAction that = (UserProblemAction) o;
        return this.userId.equals(that.userId) && this.problemId.equals(that.problemId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, problemId);
    }
}
