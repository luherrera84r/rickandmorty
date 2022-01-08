package com.mobdev.rickandmorty.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class CharacterModel {
    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationModel origin;
    private LocationModel location;
    private String image;
    private String[] episode;
    private String url;
    private OffsetDateTime created;
}
