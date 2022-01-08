package com.mobdev.rickandmorty.domain.gateway;

import com.mobdev.rickandmorty.domain.model.CharacterModel;

public interface CharacterGateway {

    CharacterModel getCharacter(Integer id);
}
