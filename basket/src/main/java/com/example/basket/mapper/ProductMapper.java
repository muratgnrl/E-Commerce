package com.example.basket.mapper;

import com.example.basket.dto.ProductDto;
import com.example.basket.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product>{
}
