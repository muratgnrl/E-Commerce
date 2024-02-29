package com.example.basketservice.mapper;

import com.example.basketservice.dto.BasketDetailsDto;
import com.example.basketservice.entity.BasketDetails;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BasketDetailsMapper extends IEntityMapper<BasketDetailsDto, BasketDetails>{
}
