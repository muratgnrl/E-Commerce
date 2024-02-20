package com.example.basket.mapper;

import com.example.basket.dto.BasketDetailsDto;
import com.example.basket.model.BasketDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketDetailsMapper extends IEntityMapper<BasketDetailsDto, BasketDetails>{
}
