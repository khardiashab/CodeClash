package com.cody.codeclash.entities;

import com.cody.codeclash.entities.enums.Language;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Profile {

    private String bio;

    private Language primaryCodingLanguage;


    private String avatar;

    private String website;

    private String location;

    private String github;

    private String twitter;

    private String linkedin;

}
