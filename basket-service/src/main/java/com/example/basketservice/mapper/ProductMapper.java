package com.example.basketservice.mapper;

import com.example.basketservice.dto.ProductDto;
import com.example.basketservice.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product> {
}
