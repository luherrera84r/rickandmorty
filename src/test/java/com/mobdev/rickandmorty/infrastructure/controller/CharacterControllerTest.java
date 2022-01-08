package com.mobdev.rickandmorty.infrastructure.controller;

import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.infrastructure.mapper.CharacterMapper;
import com.mobdev.rickandmorty.infrastructure.util.GeneratorObjectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CharacterController.class)
public class CharacterControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CharacterController characterController;

    CharacterModel character;

    @BeforeEach
    void setup() {

        character = GeneratorObjectUtil.getNewObjectCharacterTest();

    }

    @Test
    void getCharacter() throws Exception {

        CharacterMapper characterMapper = new CharacterMapper();

        when(characterController.getCharacter(1))
                .thenReturn(ResponseEntity.ok(characterMapper.fromEntity(character)));

        mvc.perform(MockMvcRequestBuilders.get("/api/character/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Rick Sanchez"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Alive"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.species").value("Human"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value(""))
                .andExpect(status().isOk());

    }
}
