package com.example.basket.service;

import com.example.basket.dto.*;
import com.example.basket.exception.FindException;
import com.example.basket.mapper.BasketDetailsMapper;
import com.example.basket.mapper.BasketMapper;
import com.example.basket.model.Basket;
import com.example.basket.model.BasketDetails;
import com.example.basket.repository.BasketDetailsRepository;
import com.example.basket.repository.BasketRepository;
import com.example.basket.response.BasketResponse;
import com.example.basket.response.PaymentResponse;
import com.example.basket.response.ProductResponse;
import com.hazelcast.core.HazelcastInstance;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final HazelcastInstance hazelcastInstance;
    private final BasketDetailsRepository basketDetailsRepository;
    private final Map<String, Basket> basketMap;
    private final BasketDetailsMapper basketDetailsMapper;
    public BasketService(BasketRepository basketRepository, BasketMapper basketMapper, @Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance, BasketDetailsRepository basketDetailsRepository, Map<String, Basket> basketMap, BasketDetailsMapper basketDetailsMapper) {
        this.basketRepository = basketRepository;
        this.basketMapper = basketMapper;
        this.hazelcastInstance = hazelcastInstance;
        this.basketDetailsRepository = basketDetailsRepository;
        this.basketMap = basketMap;
        this.basketDetailsMapper = basketDetailsMapper;
    }
    public ProductResponse sendRequestProductService(int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9112/product/productFind/" + productId, ProductResponse.class);
    }

    public UserDto findUserById(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9061/user/find/" + userId, UserDto.class);
    }
    public PaymentResponse sendRequestPaymentId(int paymentId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("" + paymentId, PaymentResponse.class);
    }

    public String addProductToBasket(BasketDetailsDto dto) {
        ProductResponse productResponse=new ProductResponse();
        ProductDto productDto=productResponse.productDto;
        BasketDetails basketDetails=new BasketDetails();
        Basket basket=findBasketByuserIdForActivity(dto.userId,1);
        basketDetails.setCount(dto.count);
        basketDetails.setBasket(basket);
        basketDetails.setProductId(dto.productId);
        basketDetailsRepository.save(basketDetails);
        basket.setTotalAmount(setAmount(basket, dto , productDto));
        basketRepository.save(basket);
        return "Ürün sepete eklendi";
    }


    public List<ProductDto> getBasket(GetBasketDto getBasketDto) {
        Basket basket=basketRepository.findBasketsByUserIdAndStatus(getBasketDto.userId, 1);
        List<ProductDto> productDtoList=new ArrayList<>();
        List<BasketDetails> basketDetails=basketDetailsRepository.findBasketDetailsByBasket(basket);
        for (BasketDetails basketDetail : basketDetails){
            ProductResponse productResponse = sendRequestProductService(basketDetail.getProductId());

            productDtoList.add(productResponse.productDto);

        }
        return productDtoList;


    }

    private double setAmount(Basket basket, BasketDetailsDto dto, ProductDto productDto) {
        double amount = 0;
        for (int i = 0; i < dto.count; i++) {
            amount = amount + productDto.productAmount;

        }
        basket.setTotalAmount(basket.getTotalAmount() + amount);
        return basket.getTotalAmount();

    }


    private Basket findBasketByuserIdForActivity(int userId, int basketActivity) {
          Basket basket = basketRepository.findBasketsByUserIdAndStatus(userId,basketActivity);
        if (basket == null){
        basket = newBasket(userId);
    }
        return basket;

    }

    private Basket newBasket(int userId) {
        UserDto userDto = findUserById(userId);
        Basket basket = new Basket();
        basket.setUserId(userDto.userId);
        basket.setStatus(1);
        basketRepository.save(basket);

        return basket;
    }
    public ResponseEntity<BasketDto> getBasketByBasketId(int basketId) throws FindException {
        Basket basket = getSession(String.valueOf(basketId));
        if (basket == null) {
            basket = basketRepository.findBasketByBasketId(basketId);
            if (basket == null) {
                throw new FindException();
            }
            addSession(String.valueOf(basket.getBasketId()),basket);
        }
        return ResponseEntity.ok(basketMapper.toResource(basket));
    }

    private Basket getSession(String key) {
        Map<String, Basket> basketMap = hazelcastInstance.getMap("basketMap");
        return basketMap.get(key);
    }
    private void addSession(String key, Basket order) {
        Map<String, Basket> basketMap = hazelcastInstance.getMap("basketMap");
        basketMap.put(key, order);
    }



    public BasketResponse updateBasket(BasketDto basketDto) {
        BasketResponse basketResponse = new BasketResponse();
        Basket basket = basketRepository.findBasketByBasketId(basketDto.basketId);
        basket.setStatus(basketDto.status);
        basket = basketRepository.save(basket);
        return basketResponse;

    }
}

