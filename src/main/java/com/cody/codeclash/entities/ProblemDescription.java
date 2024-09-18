package com.cody.codeclash.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class ProblemDescription {

    @Id
    @Column(updatable = false, nullable = false, name = "id")
    private Long id;

    // how to define one to one relationship
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Problem problem;

    private String description;

    private String examples;

    // ? do something about
    private List<String> constraints;

    @Override
    public String toString() {
        return "ProblemDescription [id=" + id + ", description=" + description + ", examples=" + examples
                + ", constraints=" + constraints + "]";
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
        ProblemDescription other = (ProblemDescription) obj;
        return Objects.equals(id, other.id);
    }

}
