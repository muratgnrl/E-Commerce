package com.example.interactionservice.dto;



import java.io.Serializable;
import java.util.List;

public class FavouritesDto implements Serializable {
    public long favoriteId;
    public String favoriteDesc;
    public List<ProductDto> productList;
}
