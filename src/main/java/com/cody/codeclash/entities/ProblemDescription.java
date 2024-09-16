package com.cody.codeclash.entities;

import lombok.Data;
import java.util.Objects;

import jakarta.persistence.*;

@Data
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

    private String constraints;



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
