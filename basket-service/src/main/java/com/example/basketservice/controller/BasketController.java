package com.example.basketservice.controller;

import com.example.basketservice.dto.BasketDetailsDto;
import com.example.basketservice.dto.BasketDto;
import com.example.basketservice.dto.GetBasketDto;
import com.example.basketservice.dto.ProductDto;
import com.example.basketservice.exception.FindBasketException;
import com.example.basketservice.response.BasketResponse;
import com.example.basketservice.service.ımpl.BasketServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private final BasketServiceImpl basketService;

    public BasketController(BasketServiceImpl basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/addBasket")
    public String addProductToBasket(@RequestBody BasketDetailsDto basketDetailsDto) {
        return basketService.addProductToBasket(basketDetailsDto);
    }

    @PostMapping("/getBasket")
    public List<ProductDto> addProductToBasket(@RequestBody GetBasketDto dto) {
        return basketService.getBasket(dto);
    }

    @GetMapping("getBasket/{basketId}")
    public ResponseEntity<BasketDto> getBasketByBasketId(@PathVariable(value = "basketId") long basketId) throws FindBasketException {
        return basketService.getBasketByBasketId(basketId);
    }

    @PostMapping("/updateBasket")
    public BasketResponse updateBasket(@RequestBody BasketDto basketDto) {
        return basketService.updateBasket(basketDto);
    }
}
