package com.cody.codeclash.entities;

import java.util.Set;

import com.cody.codeclash.entities.enums.Difficulty;
import com.cody.codeclash.entities.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private Difficulty difficulty;


    private Status status = Status.DRAFT;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private Set<Tag> tags;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProblemDescription description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProblemSocialInteraction interaction;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProblemEntryCodeAndTestCases solutionsAndTestCases;

    private Long authorId;

    private String authorName;
    public void addTag(Tag tag) {
        if (tags == null) {
            tags = Set.of();
        }
        tags.add(tag);
    }

    public void removeTag(Tag tag){
        if(tags != null){
            tags.remove(tag);
        }
    }
    @Override
    public String toString() {
        return "Problem [id=" + id + ", title=" + title + ", difficulty=" + difficulty +
        ", decription=" + (description != null ? description.getId() : "null") +
        ", tags=" + (tags != null ? tags.size() : "null") +
        ", interaction=" + (interaction != null ? interaction.getId() : "null") +
         "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Problem other = (Problem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
