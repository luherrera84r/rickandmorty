package com.mobdev.rickandmorty.infrastructure.mapper;

public interface Mapper<D, E> {

    public D fromEntity(E entity);
}
