package com.mobdev.rickandmorty.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    @JsonProperty("episode_count")
    private Integer episodeCount;
    @JsonProperty("origin")
    private LocationDTO origin;
}
