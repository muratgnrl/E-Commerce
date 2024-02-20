package com.example.authservice.mapper;

import java.util.List;

public interface IEntityMapper <R, E> {

    R toResource(E e);

    E toEntity(R r);

    List<R> toResourse(List<E> eList);

    List<E> toEntity(List<R> rList);
}