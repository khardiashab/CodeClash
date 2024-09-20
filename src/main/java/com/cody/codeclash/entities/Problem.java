package com.cody.codeclash.entities;

import java.util.List;
import java.util.Set;
import java.util.Objects;

import com.cody.codeclash.entities.enums.Difficulty;
import com.cody.codeclash.entities.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToOne(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProblemDescription description;

    @OneToOne(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProblemSocialInteraction interaction;

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
        return "Problem [id=" + id + ", title=" + title + ", difficulty=" + difficulty + ", status=" + status +", authorId=" + authorId + ", authorName=" + authorName + "]";
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
        Problem other = (Problem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
