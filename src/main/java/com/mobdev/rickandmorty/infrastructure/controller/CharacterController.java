package com.mobdev.rickandmorty.infrastructure.controller;

import com.mobdev.rickandmorty.application.usercase.CharacterUseCase;
import com.mobdev.rickandmorty.infrastructure.dto.CharacterDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class CharacterController {

    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    private final CharacterUseCase characterUseCase;

    @GetMapping("/character/{id}")
    ResponseEntity<CharacterDTO> getCharacter(@PathVariable("id") Integer id){

        logger.info("initialize api rest Ricky and Morty - Challenge");
        return ResponseEntity.ok(characterUseCase.getCharacter(id));
    }
}