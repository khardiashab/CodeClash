package com.cody.codeclash.entities;

import java.util.Objects;

import com.cody.codeclash.entities.enums.Reaction;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class UserProblemAction {

    @EmbeddedId
    private UserProblemActionKey id;

    @MapsId
    private Long userId;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    private Problem problem;

    private Reaction reaction;

    private boolean saved;

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

}
