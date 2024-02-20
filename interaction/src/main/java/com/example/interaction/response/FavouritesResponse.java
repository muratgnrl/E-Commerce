package com.example.interaction.response;

import com.example.interaction.dto.FavouritesDto;
import com.example.interaction.entity.Favourites;

import java.io.Serializable;

public class FavouritesResponse extends BaseResponse implements Serializable {
    public FavouritesDto favouritesDto;
}
