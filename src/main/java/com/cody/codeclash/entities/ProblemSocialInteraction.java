package com.cody.codeclash.entities;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class ProblemSocialInteraction {

    @Id
    private Long id;

    // Unidirectional one-to-one mapping, Problem is the owner of the relationship
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id") // Using the same primary key
    private Problem problem;

    private Long likes = 0L;
    private Long dislikes = 0L;
    private Long saves = 0L;
    private Long submitCount = 0L;
    private Long solvedCount = 0L;

    @Override
    public String toString() {
        return "ProblemSocialInteraction [id=" + id + ", likes=" + likes + ", dislikes=" + dislikes + ", saves="
                + saves + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProblemSocialInteraction other = (ProblemSocialInteraction) obj;
        return Objects.equals(id, other.id);
    }

}
