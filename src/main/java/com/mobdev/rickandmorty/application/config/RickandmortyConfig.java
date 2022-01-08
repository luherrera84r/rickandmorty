package com.mobdev.rickandmorty.application.config;

import com.mobdev.rickandmorty.application.usercase.CharacterUseCase;
import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.infrastructure.adapter.*;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.CharacterRequestRest;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.LocationRequestRest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RickandmortyConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CharacterUseCase getCharacter(CharacterGateway characterGateway){
        return new CharacterUseCase(characterGateway);
    }

    @Bean
    public CharacterRequestRest characterRequest(){
        return new CharacterRequestRestImpl(restTemplate());
    }

    @Bean
    public LocationRequestRest locationRequestRest(RestTemplate restTemplate){
        return new LocationRequestRestImpl(restTemplate());
    }

    @Bean
    public CharacterGateway characterService(CharacterRequestRest cRequest, LocationRequestRest lRequest){
        return new ApiCharacterService(cRequest, lRequest);
    }
}
