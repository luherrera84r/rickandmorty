package com.mobdev.rickandmorty.application.usercase;

import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.infrastructure.dto.CharacterDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CharacterUseCase {

    private final CharacterGateway serviceGateway;

    public CharacterDTO getCharacter(Integer id){
        return serviceGateway.getCharacter(id);
    }



}
