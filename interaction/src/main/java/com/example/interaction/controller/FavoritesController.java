package com.example.interaction.controller;

import com.example.interaction.dto.FavouritesDto;
import com.example.interaction.exception.AddFavouritesException;
import com.example.interaction.response.FavouritesResponse;
import com.example.interaction.service.FavouritesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favourites")
public class FavoritesController {

    private final FavouritesService service;

    public FavoritesController(FavouritesService service) {
        this.service = service;
    }

    @PostMapping("/addFavourites")
    public FavouritesResponse addFavourites(@RequestBody FavouritesDto favouritesDto)throws AddFavouritesException {
        return service.addFavourites(favouritesDto);
    }
}
