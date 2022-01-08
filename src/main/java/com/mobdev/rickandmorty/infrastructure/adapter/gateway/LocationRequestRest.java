package com.mobdev.rickandmorty.infrastructure.adapter.gateway;

import com.mobdev.rickandmorty.domain.model.LocationModel;

public interface LocationRequestRest {
    public LocationModel getLocationObject(String url);

}
