package com.mobdev.rickandmorty.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LocationDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String url;
    private String dimension;
    private List<String> residents;
}
