package com.example.basketservice.service.ımpl;

import com.example.basketservice.dto.*;
import com.example.basketservice.entity.Basket;
import com.example.basketservice.entity.BasketDetails;
import com.example.basketservice.exception.FindBasketException;
import com.example.basketservice.mapper.BasketDetailsMapper;
import com.example.basketservice.mapper.BasketMapper;
import com.example.basketservice.repository.BasketDetailsRepository;
import com.example.basketservice.repository.BasketRepository;
import com.example.basketservice.response.BasketResponse;
import com.example.basketservice.response.PaymentResponse;
import com.example.basketservice.response.ProductResponse;
import com.example.basketservice.service.BasketService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.hazelcast.core.HazelcastInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final BasketDetailsRepository basketDetailsRepository;
    private final BasketMapper basketMapper;
    private final BasketDetailsMapper basketDetailsMapper;
    private final HazelcastInstance hazelcastInstance;
    private final Map<String, Basket> basketMap;

    public BasketServiceImpl(BasketRepository basketRepository, BasketDetailsRepository basketDetailsRepository, BasketMapper basketMapper, BasketDetailsMapper basketDetailsMapper, @Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance, Map<String, Basket> basketMap) {
        this.basketRepository = basketRepository;
        this.basketDetailsRepository = basketDetailsRepository;
        this.basketMapper = basketMapper;
        this.basketDetailsMapper = basketDetailsMapper;
        this.hazelcastInstance = hazelcastInstance;
        this.basketMap = basketMap;
    }

    public UserDto findUserById(long userId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:7070/users/getUser/" + userId, UserDto.class);
    }
    public ProductResponse sendRequestProductService(long productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:7030/product/findProduct/" + productId, ProductResponse.class);
    }
    public PaymentResponse sendRequestPaymentId(long paymentId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("" + paymentId, PaymentResponse.class);
    }

    @Override
    public String addProductToBasket(BasketDetailsDto basketDetailsDto) {
        ProductResponse productResponse = sendRequestProductService(basketDetailsDto.productId);
        ProductDto productDto = productResponse.productDto;
        BasketDetails basketDetails = new BasketDetails();
        Basket basket = findBasketByuserIdForActivity(basketDetailsDto.userId, 1);
        basketDetails.setBasket(basket);
        basketDetails.setProductId(productDto.productId);
        basketDetails.setCount(basketDetailsDto.count);
        basketDetailsRepository.save(basketDetails);
        basket.setTotalAmount(setAmount(basket, basketDetailsDto, productDto));
        basketRepository.save(basket);
        return "Ürün sepete eklendi";
    }

    public ResponseEntity<BasketDto> getBasketByBasketId(long basketId) throws FindBasketException {
        Basket basket = getSession(basketId);
        if (basket == null) {
            basket = basketRepository.findBasketByBasketId(basketId);
            if (basket == null) {
                throw new FindBasketException();
            }

        }
        return ResponseEntity.ok(basketMapper.toResource(basket));
    }

    private Basket getSession(long basketId) {
        Map<String, Basket> basketMap = hazelcastInstance.getMap("basketMap");
        return basketMap.get(basketId);
    }


    @Override
    public List<ProductDto> getBasket(GetBasketDto dto) {
        Basket basket = basketRepository.findBasketsByUserIdAndStatus(dto.userId, 1);
        List<ProductDto> productDtos = new ArrayList<>();
        List<BasketDetails> basketDetails = basketDetailsRepository.findBasketDetailsByBasket(basket);
        for (BasketDetails basketDetail : basketDetails){
            ProductResponse productResponse = sendRequestProductService(basketDetail.getProductId());

            productDtos.add(productResponse.productDto);

        }
        return productDtos;
    }

    @Override
    public BasketResponse updateBasket(BasketDto basketDto) {
        BasketResponse basketResponse = new BasketResponse();
        Basket basket = basketRepository.findBasketByBasketId(basketDto.basketId);
        basket.setStatus(basketDto.status);
        basket = basketRepository.save(basket);
        return basketResponse;

    }


    private Basket findBasketByuserIdForActivity(long userId, int basketActivity) {
        Basket basket = basketRepository.findBasketsByUserIdAndStatus(userId, basketActivity);
        if (basket == null) {
            basket = newBasket(userId);
        }
        return basket;
    }

    public Basket newBasket(long userId) {
        UserDto userDto = findUserById(userId);
        Basket basket = new Basket();
        basket.setUserId(userDto.userId);
        basket.setStatus(1);
        basketRepository.save(basket);
        return basket;
    }

    public double setAmount(Basket basket, BasketDetailsDto basketDetailsDto, ProductDto productDto) {
        double amount = 0;
        for (int i = 0; i < basketDetailsDto.count; i++) {
            amount = amount + productDto.productAmount;
        }
        basket.setTotalAmount(basket.getTotalAmount() + amount);
        return basket.getTotalAmount();


    }
}
