package com.example.basket.service;

import com.example.basket.dto.BasketDetailsDto;
import com.example.basket.dto.GetBasketDto;
import com.example.basket.dto.ProductDto;
import com.example.basket.mapper.BasketMapper;
import com.example.basket.model.Basket;
import com.example.basket.model.BasketDetails;
import com.example.basket.repository.BasketDetailsRepository;
import com.example.basket.repository.BasketRepository;
import com.example.basket.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BasketService {

    public ProductResponse sendRequestProductService(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9112/product/productFind/" + productId, ProductResponse.class);
    }
    private final BasketDetailsRepository basketDetailsRepository;
    private final BasketMapper basketMapper;
    private final BasketRepository basketRepository;

    public BasketService(BasketDetailsRepository basketDetailsRepository, BasketMapper basketMapper, BasketRepository basketRepository) {
        this.basketDetailsRepository = basketDetailsRepository;
        this.basketMapper = basketMapper;
        this.basketRepository = basketRepository;
    }

    public String addProductToBasket(BasketDetailsDto basketDetailsDto) {
        ProductResponse productResponse=sendRequestProductService(basketDetailsDto.productId);
        ProductDto productDto= productResponse.productDto;
        BasketDetails basketDetails=new BasketDetails();
        Basket basket=findBasketByuserIdForActivity(basketDetailsDto.userId);
        basketDetails.setBasket(basket);
        basketDetails.setProductId(productDto.productId);
        basketDetails.setCount(basketDetailsDto.count);
        basketDetailsRepostiory.save(basketDetails);
        basket.setTotalAmount(setAmount(basket, basketDetailsDto , productDto));
        basketRepository.save(basket);
        return "ürün sepete eklendi";
    }


    public List<ProductDto> getBasket(GetBasketDto dto) {
        Basket basket=basketRepository.findBasketsByUserIdAndStatus(getBasketDto.userId, 1);
    }
}
