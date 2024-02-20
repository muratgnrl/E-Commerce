package com.example.basket.controller;

import com.example.basket.dto.BasketDetailsDto;
import com.example.basket.dto.BasketDto;
import com.example.basket.dto.GetBasketDto;
import com.example.basket.dto.ProductDto;
import com.example.basket.service.BasketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/addBasket")
    public String addProductToBasket(@RequestBody BasketDetailsDto basketDetailsDto){
        return basketService.addProductToBasket(basketDetailsDto);
    }
    @PostMapping("/getBasket")
    public List<ProductDto> addProductToBasket(@RequestBody GetBasketDto dto){
        return basketService.getBasket(dto);
    }
}
