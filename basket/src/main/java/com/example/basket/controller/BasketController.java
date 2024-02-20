package com.example.basket.controller;

import com.example.basket.dto.BasketDetailsDto;
import com.example.basket.dto.BasketDto;
import com.example.basket.dto.GetBasketDto;
import com.example.basket.dto.ProductDto;
import com.example.basket.exception.FindException;
import com.example.basket.response.BasketResponse;
import com.example.basket.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/addBasket")
    public String addProductToBasket(@RequestBody BasketDetailsDto dto){
        return basketService.addProductToBasket(dto);
    }
    @PostMapping("/getBasket")
    public List<ProductDto> addProductToBasket (@RequestBody GetBasketDto getBasketDto){
        return basketService.getBasket(getBasketDto);

    }
    @GetMapping("/getBasket/{basketId}")
    public ResponseEntity<BasketDto> getBasketByBasketId(@PathVariable(value = "basketId")String basketId)throws FindException {
        return basketService.getBasketByBasketId(Integer.parseInt(basketId));
    }
    @PostMapping("/updateBasket")
    public BasketResponse updateBasket(@RequestBody BasketDto basketDto){
        return basketService.updateBasket(basketDto);
    }
}
