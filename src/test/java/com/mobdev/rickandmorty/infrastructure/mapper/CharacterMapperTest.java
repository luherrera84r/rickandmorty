package com.mobdev.rickandmorty.infrastructure.mapper;

import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.infrastructure.dto.CharacterDTO;
import com.mobdev.rickandmorty.infrastructure.util.GeneratorObjectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CharacterMapperTest.class)
class CharacterMapperTest {

    @Mock
    CharacterMapper characterMapper;

    CharacterModel characterModel;

    @BeforeEach
    void setup() {

        characterModel = GeneratorObjectUtil.getNewObjectCharacterTest();

        CharacterDTO dto = new CharacterDTO();
        dto.setId(characterModel.getId());
        dto.setName(characterModel.getName());
        dto.setStatus(characterModel.getStatus());
        dto.setSpecies(characterModel.getSpecies());
        dto.setType(characterModel.getType());
        dto.setEpisodeCount(characterModel.getEpisode().length);

        when(characterMapper.fromEntity(characterModel)).thenReturn(dto);

    }

    @Test
    void fromEntity() {

        assertNotNull(characterMapper.fromEntity(characterModel));
    }
}