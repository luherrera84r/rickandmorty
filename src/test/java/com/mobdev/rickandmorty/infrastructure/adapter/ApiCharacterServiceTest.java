package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.domain.gateway.CharacterGateway;
import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.infrastructure.util.GeneratorObjectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@WebMvcTest(ApiCharacterServiceTest.class)
@AutoConfigureMockMvc
class ApiCharacterServiceTest {

    @MockBean
    private CharacterGateway api;

    @BeforeEach
    void setup() {

        CharacterModel characterModel = GeneratorObjectUtil.getNewObjectCharacterTest();

        when(api.getCharacter(1)).thenReturn(characterModel);
    }

    @Test
    void getCharacterIsHuman() throws Exception {

        assertTrue("Human".equals(api.getCharacter(1).getSpecies()));

    }
}