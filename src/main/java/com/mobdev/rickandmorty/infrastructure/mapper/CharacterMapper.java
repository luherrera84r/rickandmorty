package com.mobdev.rickandmorty.infrastructure.mapper;

import com.mobdev.rickandmorty.domain.model.CharacterModel;
import com.mobdev.rickandmorty.infrastructure.dto.CharacterDTO;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper implements Mapper<CharacterDTO, CharacterModel>{
    @Override
    public CharacterDTO fromEntity(CharacterModel entity) {

        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        dto.setSpecies(entity.getSpecies());
        dto.setType(entity.getType());
        dto.setEpisodeCount(entity.getEpisode().length);

        dto.setOrigin(new LocationMapper().fromEntity(entity.getOrigin()));

        return dto;
    }
}
