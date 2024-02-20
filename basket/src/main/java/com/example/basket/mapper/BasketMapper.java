package com.example.basket.mapper;


import com.example.basket.dto.BasketDto;
import com.example.basket.model.Basket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketMapper extends IEntityMapper<BasketDto, Basket>{
}
