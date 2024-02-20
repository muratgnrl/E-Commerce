package com.example.stok.service;

import com.example.stok.dto.ProductDto;
import com.example.stok.exception.ProductDeleteException;
import com.example.stok.exception.ProductFindException;
import com.example.stok.exception.ProductNotAddException;
import com.example.stok.mapper.ProductMapper;
import com.example.stok.model.Category;
import com.example.stok.model.Product;
import com.example.stok.repository.ProductRepository;
import com.example.stok.response.Meta;
import com.example.stok.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryService categoryService;
    private final Logger logger= LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository repository, ProductMapper mapper, CategoryService categoryService) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    public ProductResponse createProduct(ProductDto productDto) throws ProductNotAddException {
        Product product=new Product();
        product.setProductName(productDto.productName);
        product.setProductAmount(productDto.productAmount);
        product.setProductDescprition(productDto.productDescprition);
        Category category=categoryService.findCategory(productDto.categoryId);
        product.setCategory(category);
        product=repository.save(product);
        if (product != null) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.productDto = mapper.toResource(product);
            productResponse.meta = new Meta(200, "Ürün eklendi");
            logger.info("Ürün eklendi: " + product.getProductName());
            return productResponse;
        } else {
            logger.error("Ürün eklenemedi");
            throw new ProductNotAddException();
        }
    }

    public ProductResponse findProduct(int productId) throws ProductFindException {
        Product product=findProductByDto(productId);
        if (product!=null){
            ProductResponse response=new ProductResponse();
            response.productDto=mapper.toResource(product);
            response.meta=new Meta(200,"Ürün bulundu");
            return response;
        }else {
            throw new ProductFindException();
        }
    }

    private Product findProductByDto(int productId) {
        Product product=repository.findProductByProductId(productId);
        mapper.toResource(product);
        return product;
    }

    public List<ProductDto> productDtoList() {
        List<ProductDto> productDtoList=new ArrayList<>();
        Iterable<Product> products= repository.findAll();
        for (Product product: products){

            ProductDto productDto=mapper.toResource(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    public ProductResponse deleteProduct(int productId) throws ProductDeleteException {
        Optional<Product> product=repository.findById(productId);
        if (product.isPresent()){
            repository.deleteById(productId);
            ProductResponse response=new ProductResponse();
            response.meta=new Meta(200,"Ürün silindi");
            return response;
        }else {
            throw new ProductDeleteException();
        }
    }


    public ProductDto updateProduct(ProductDto productDto, int productId) {
        Product product=mapper.toEntity(productDto);
        Product products=repository.findProductByProductId(productId);

       products.setProductName(product.getProductName());
       products.setProductDescprition(product.getProductDescprition());
       products.setProductAmount(product.getProductAmount());
       Product updateProduct=repository.save(products);
       ProductDto dto=mapper.toResource(updateProduct);
       return dto;
    }
}
