package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.application.error.CharacterNotFoundException;
import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.domain.model.LocationModel;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.CharacterRequestRest;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.LocationRequestRest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@RequiredArgsConstructor
public class ApiCharacterService implements CharacterGateway {

    private static final Logger logger = LoggerFactory.getLogger(ApiCharacterService.class);

    private final CharacterRequestRest cRequest;
    private final LocationRequestRest lRequest;

    @Override
    public CharacterModel getCharacter(Integer id) {

        CharacterModel character = cRequest.getCharacterObject(id);

        if(null != character && null!=character.getOrigin().getUrl() && !character.getOrigin().getUrl().isEmpty()){
            LocationModel location = lRequest.getLocationObject(character.getOrigin().getUrl());

            logger.info("Answer Character object value: " + character.toString());
            logger.info("Answer Location object value: " +location.toString());
            character.setLocation(location);
        }

        if(Objects.isNull(character)) {
            throw new CharacterNotFoundException();
        }

        return character;
    }
}
