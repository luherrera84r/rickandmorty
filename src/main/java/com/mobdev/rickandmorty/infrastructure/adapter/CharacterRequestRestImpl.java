package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.CharacterRequestRest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class CharacterRequestRestImpl implements CharacterRequestRest {

    private final RestTemplate rest;

    private static final Logger logger = LoggerFactory.getLogger(CharacterRequestRestImpl.class);

    @Value("${endpoint.rickandmorty.character}")
    private String urlEndPoint;

    @Override
    public CharacterModel getCharacterObject(Integer id) {

        logger.info("Endpoint to consult --> " + urlEndPoint);
        logger.info("Id Character: " + id);

        try {
            return rest.getForObject(urlEndPoint.concat(String.valueOf(id)), CharacterModel.class);
        }catch(HttpClientErrorException e){
            logger.error("Request error: " + e.getMessage());

        }
        return null;
    }

}
