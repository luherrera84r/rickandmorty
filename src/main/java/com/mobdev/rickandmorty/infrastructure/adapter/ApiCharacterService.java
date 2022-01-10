package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.application.error.CharacterNotFoundException;
import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.domain.model.LocationModel;
import com.mobdev.rickandmorty.infrastructure.dto.CharacterDTO;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.CharacterRequestRest;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.LocationRequestRest;
import com.mobdev.rickandmorty.infrastructure.mapper.CharacterMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@RequiredArgsConstructor
public class ApiCharacterService implements CharacterGateway {

    private final CharacterRequestRest cRequest;
    private final LocationRequestRest lRequest;
    private final CharacterMapper characterMapper;

    private static final Logger logger = LoggerFactory.getLogger(ApiCharacterService.class);

    @Override
    public CharacterDTO getCharacter(Integer id) {

        CharacterModel character = cRequest.getCharacterObject(id);
        logger.info("Answer Character object value: " + character.toString());

        if(null != character && null!=character.getOrigin().getUrl() && !character.getOrigin().getUrl().isEmpty()){
            LocationModel location = lRequest.getLocationObject(character.getOrigin().getUrl());

            logger.info("Answer Location object value: " +location.toString());
            character.setOrigin(location);
        }

        if(Objects.isNull(character)) {
            throw new CharacterNotFoundException();
        }

        return characterMapper.fromEntity(character);
    }
}
