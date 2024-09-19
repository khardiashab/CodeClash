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


}
