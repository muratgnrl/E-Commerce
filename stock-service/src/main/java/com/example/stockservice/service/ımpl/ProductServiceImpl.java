package com.example.stockservice.service.ımpl;

import com.example.stockservice.dto.ProductDto;
import com.example.stockservice.exception.ProductCreateException;
import com.example.stockservice.exception.ProductDeleteException;
import com.example.stockservice.exception.ProductNotFoundException;
import com.example.stockservice.mapper.ProductMapper;
import com.example.stockservice.model.Category;
import com.example.stockservice.model.Product;
import com.example.stockservice.repository.ProductRepository;
import com.example.stockservice.response.Meta;
import com.example.stockservice.response.ProductResponse;
import com.example.stockservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryServiceImpl categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryServiceImpl categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public ProductResponse addProduct(ProductDto productDto) throws ProductCreateException {
        Product product = ProductMapper.mapToEntity(productDto);
        Category category = categoryService.findByCategory(productDto.categoryId);
        product.setCategory(category);
        product=productRepository.save(product);
        if (product!=null){
            ProductResponse productResponse =new ProductResponse();
            productResponse.meta=new Meta(200,"Ürün eklendi");
            productResponse.product=ProductMapper.mapToDto(product);
            return productResponse;
        }else {
            throw new ProductCreateException();
        }
    }

    @Override
    public ProductResponse getProduct(long productId) throws ProductNotFoundException {
        Product product = productRepository.findByProductId(productId);
        if (product!=null){
            ProductResponse productResponse =new ProductResponse();
            productResponse.meta=new Meta(200,"Ürün bulundu");
            productResponse.product=ProductMapper.mapToDto(product);
            return productResponse;
        }else {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public ProductResponse deleted(long productId) throws ProductDeleteException { ProductResponse productResponse =new ProductResponse();
        Product product =productRepository.findByProductId(productId);
        if (product!=null){
            productResponse.product=ProductMapper.mapToDto(product);
            productResponse.meta=new Meta(200,"Ürün silindi  =" +" " + productId);
            productRepository.delete(product);
            return productResponse;
        }else {
            throw new ProductDeleteException();
        }
    }
}
