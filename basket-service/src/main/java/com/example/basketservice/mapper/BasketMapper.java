package com.example.basketservice.mapper;

import com.example.basketservice.dto.BasketDto;
import com.example.basketservice.entity.Basket;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BasketMapper extends IEntityMapper<BasketDto, Basket>{
}
