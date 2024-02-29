package com.example.interactionservice.mapper;

import java.util.List;

public interface IEntityMapper<R,E> {
    R toDto(E e);
    E toEntity(R r);

    List<R> toDto(List<E>eList);
    List<E> toEntity(List<R> rList);
 }
