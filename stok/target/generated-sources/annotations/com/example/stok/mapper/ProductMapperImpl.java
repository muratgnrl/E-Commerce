package com.example.stok.mapper;

import com.example.stok.dto.ProductDto;
import com.example.stok.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T13:51:00+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toResource(Product e) {
        if ( e == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.productId = e.getProductId();
        productDto.productName = e.getProductName();
        productDto.productDescprition = e.getProductDescprition();
        productDto.productAmount = e.getProductAmount();

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto r) {
        if ( r == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( r.productId );
        product.setProductName( r.productName );
        product.setProductDescprition( r.productDescprition );
        product.setProductAmount( r.productAmount );

        return product;
    }

    @Override
    public List<ProductDto> toResourse(List<Product> eList) {
        if ( eList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( eList.size() );
        for ( Product product : eList ) {
            list.add( toResource( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( rList.size() );
        for ( ProductDto productDto : rList ) {
            list.add( toEntity( productDto ) );
        }

        return list;
    }
}
