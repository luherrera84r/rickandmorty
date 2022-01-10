package com.mobdev.rickandmorty.domain.gateway;

import com.mobdev.rickandmorty.infrastructure.dto.CharacterDTO;

public interface CharacterGateway {

    CharacterDTO getCharacter(Integer id);
}
