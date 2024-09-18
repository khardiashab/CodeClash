package com.cody.codeclash.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToOne
    @JoinColumn(name = "id")
    private Problem problem;

    private Long likes;
    private Long dislikes;

    private Long saves;

    @OneToMany(mappedBy = "interaction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "interaction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @Override
    public String toString() {
        return "ProblemSocialInteraction [id=" + id + ", likes=" + likes + ", dislikes=" + dislikes + ", saves="
                + saves + ", comments=" + (comments != null ? comments.size() : "null") + ", ratings="
                + (ratings != null ? ratings.size() : "null") + "]";
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
