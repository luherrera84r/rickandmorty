package com.mobdev.rickandmorty.infrastructure.adapter;

import com.mobdev.rickandmorty.domain.model.LocationModel;
import com.mobdev.rickandmorty.infrastructure.adapter.gateway.LocationRequestRest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class LocationRequestRestImpl implements LocationRequestRest {

    private final RestTemplate rest;

    @Override
    public LocationModel getLocationObject(String url) {
        return rest.getForObject(url, LocationModel.class);
    }
}
