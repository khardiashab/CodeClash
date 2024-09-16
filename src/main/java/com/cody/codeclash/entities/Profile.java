package com.cody.codeclash.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Profile {

    private String bio;

    private Enum primaryCodingLanguage;


    private String avatar;

    private String website;

    private String location;

    private String github;

    private String twitter;

    private String linkedin;

}
