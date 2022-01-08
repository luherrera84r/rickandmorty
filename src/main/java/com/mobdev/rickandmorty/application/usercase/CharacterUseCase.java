package com.mobdev.rickandmorty.application.usercase;

import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.domain.model.CharacterModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CharacterUseCase {

    private final CharacterGateway serviceGateway;

    public CharacterModel getCharacter(Integer id){
        return serviceGateway.getCharacter(id);
    }



}
