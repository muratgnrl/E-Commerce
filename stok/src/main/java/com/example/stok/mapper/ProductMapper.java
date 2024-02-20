package com.example.stok.mapper;

import com.example.stok.dto.ProductDto;
import com.example.stok.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product>{
}
