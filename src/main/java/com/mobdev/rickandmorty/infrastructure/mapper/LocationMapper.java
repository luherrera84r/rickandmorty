package com.mobdev.rickandmorty.infrastructure.mapper;

import com.mobdev.rickandmorty.infrastructure.dto.LocationDTO;
import com.mobdev.rickandmorty.domain.model.LocationModel;
import java.util.stream.Collectors;

public class LocationMapper implements Mapper<LocationDTO, LocationModel>{
    @Override
    public LocationDTO fromEntity(LocationModel entity) {
        LocationDTO dto = new LocationDTO();
        dto.setName(entity.getName());
        dto.setUrl(entity.getUrl());
        dto.setDimension(entity.getDimension());

        if(null != entity.getResidents() && !entity.getResidents().isEmpty()){
            dto.setResidents(entity.getResidents().stream().collect(Collectors.toList()));
        }

        return dto;
    }
}
