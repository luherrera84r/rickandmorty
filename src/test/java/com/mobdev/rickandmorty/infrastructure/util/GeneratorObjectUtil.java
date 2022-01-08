package com.mobdev.rickandmorty.infrastructure.util;

import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.domain.model.LocationModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeneratorObjectUtil
{
   public static CharacterModel getNewObjectCharacterTest(){

        CharacterModel character = new CharacterModel();
        character.setId(1);
        character.setName("Rick Sanchez");
        character.setStatus("Alive");
        character.setSpecies("Human");
        character.setType("");
        character.setEpisode(new String[]{"test1","test2"});


        LocationModel locationModel = new LocationModel();
        locationModel.setId(1);
        locationModel.setType("Planet");
        locationModel.setName("Earth (C-137)");
        locationModel.setDimension("Dimension C-137");
        locationModel.setUrl("https://rickandmortyapi.com/api/location/1");
        locationModel.setCreated(LocalDateTime.now());

        List<String> listResident = new ArrayList<String>();
        listResident.add("https://rickandmortyapi.com/api/character/38");
        listResident.add("https://rickandmortyapi.com/api/character/45");

        locationModel.setResidents(listResident);
       //character.setOrigin(getNewObjectLocationTest());

        character.setOrigin(locationModel);
        character.setLocation(locationModel);


        return character;
    }

    public static LocationModel getNewObjectLocationTest(){

        LocationModel locationModel = new LocationModel();
        locationModel.setId(1);
        locationModel.setType("Planet");
        locationModel.setName("Earth (C-137)");
        locationModel.setDimension("Dimension C-137");
        locationModel.setUrl("https://rickandmortyapi.com/api/location/1");
        locationModel.setCreated(LocalDateTime.now());

        List<String> listResident = new ArrayList<String>();
        listResident.add("https://rickandmortyapi.com/api/character/38");
        listResident.add("https://rickandmortyapi.com/api/character/45");

        locationModel.setResidents(listResident);

        return locationModel;
    }
}
