package com.mobdev.rickandmorty;

import com.mobdev.rickandmorty.application.usercase.CharacterUseCase;
import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.infrastructure.adapter.ApiCharacterService;
import com.mobdev.rickandmorty.infrastructure.adapter.CharacterRequestRestImpl;
import com.mobdev.rickandmorty.infrastructure.adapter.LocationRequestRestImpl;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.CharacterRequestRest;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.LocationRequestRest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RickandmortyApplicationTests {

	@Test
	void contextLoads() {
	}


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

	@Bean
	ApiCharacterService api(CharacterRequestRest cRequest, LocationRequestRest lRequest){
		return new ApiCharacterService(cRequest, lRequest);
	}
}
