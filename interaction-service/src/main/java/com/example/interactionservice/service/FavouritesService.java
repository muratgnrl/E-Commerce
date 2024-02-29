package com.example.interactionservice.service;

import com.example.interactionservice.dto.FavouritesDto;
import com.example.interactionservice.dto.UserDto;
import com.example.interactionservice.exception.AddFavouritesException;
import com.example.interactionservice.exception.FavouritesDeleteException;
import com.example.interactionservice.exception.FavouritesNotFoundException;
import com.example.interactionservice.response.FavouritesResponse;

import java.util.List;

public interface FavouritesService {
    FavouritesResponse addFavourites(FavouritesDto favouritesDto) throws AddFavouritesException;
    List<FavouritesDto> getAllFavourites();

    FavouritesResponse findFavourite(long favoriteId) throws FavouritesNotFoundException;

    FavouritesResponse deleteFavourites(long favoriteId) throws FavouritesDeleteException;
}
