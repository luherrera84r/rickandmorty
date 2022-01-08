package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.CharacterRequestRest;
import com.mobdev.rickandmorty.infrastructure.util.GeneratorObjectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(CharacterRequestRestImplTest.class)
class CharacterRequestRestImplTest {

    @Mock
    CharacterRequestRest character;

    @BeforeEach
    void setup() {

        CharacterModel characterModel = GeneratorObjectUtil.getNewObjectCharacterTest();

        when(character.getCharacterObject(1)).thenReturn(characterModel);
    }

    @Test
    void getCharacterObject() {

        assertEquals(character.getCharacterObject(1).getId(), 1);
        assertEquals(character.getCharacterObject(1).getName(), "Rick Sanchez");
        assertEquals(character.getCharacterObject(1).getStatus(), "Alive");
        assertEquals(character.getCharacterObject(1).getSpecies(), "Human");

    }
}