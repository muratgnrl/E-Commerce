package com.example.basketservice.service;

import com.example.basketservice.dto.BasketDetailsDto;
import com.example.basketservice.dto.BasketDto;
import com.example.basketservice.dto.GetBasketDto;
import com.example.basketservice.dto.ProductDto;
import com.example.basketservice.exception.FindBasketException;
import com.example.basketservice.response.BasketResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BasketService {
    String addProductToBasket(BasketDetailsDto basketDetailsDto);



    ResponseEntity<BasketDto> getBasketByBasketId(long basketId) throws FindBasketException;

    List<ProductDto> getBasket(GetBasketDto dto);

    BasketResponse updateBasket(BasketDto basketDto);
}
