package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.domain.model.LocationModel;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.LocationRequestRest;
import com.mobdev.rickandmorty.infrastructure.util.GeneratorObjectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(LocationRequestRestImplTest.class)
class LocationRequestRestImplTest {

    @Mock
    LocationRequestRest locationRequestRest;

    private static final String URL = "https://rickandmortyapi.com/api/location/1";

    @BeforeEach
    void setup() {

        LocationModel locationModel = GeneratorObjectUtil.getNewObjectLocationTest();

        when(locationRequestRest.getLocationObject(URL)).thenReturn(locationModel);

    }

    @Test
    void getLocationObject() {

        LocationModel locationModelOut = locationRequestRest.getLocationObject(URL);
        assertEquals("Earth (C-137)", locationModelOut.getName());
        assertEquals("Planet", locationModelOut.getType());
        assertEquals("Dimension C-137", locationModelOut.getDimension());

    }
}