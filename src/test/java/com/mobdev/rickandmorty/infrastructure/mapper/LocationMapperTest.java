package com.mobdev.rickandmorty.infrastructure.mapper;

import com.mobdev.rickandmorty.domain.model.LocationModel;
import com.mobdev.rickandmorty.infrastructure.dto.LocationDTO;
import com.mobdev.rickandmorty.infrastructure.util.GeneratorObjectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(LocationMapperTest.class)
class LocationMapperTest {

    @Mock
    LocationMapper locationMapper;

    LocationModel locationModel;

    @BeforeEach
    void setup() {

        locationModel = GeneratorObjectUtil.getNewObjectLocationTest();

        LocationDTO dto = new LocationDTO();
        dto.setName(locationModel.getName());
        dto.setDimension(locationModel.getDimension());
        dto.setUrl(locationModel.getUrl());
        dto.setResidents(locationModel.getResidents());

        when(locationMapper.fromEntity(locationModel)).thenReturn(dto);

    }
    @Test
    void fromEntity() {
        assertNotNull(locationMapper.fromEntity(locationModel));
    }
}