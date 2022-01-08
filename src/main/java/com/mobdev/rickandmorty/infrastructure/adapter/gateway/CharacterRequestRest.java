package com.mobdev.rickandmorty.infrastructure.adapter.gateway;

import com.mobdev.rickandmorty.domain.model.CharacterModel;

public interface CharacterRequestRest {

    public CharacterModel getCharacterObject(Integer id);
}
