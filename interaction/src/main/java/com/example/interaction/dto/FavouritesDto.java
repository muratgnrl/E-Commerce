package com.example.interaction.dto;

import com.example.interaction.entity.Product;
import jakarta.persistence.OneToMany;

import java.util.List;

public class FavouritesDto {
    private int favoriteId;
    private String favoriteDesc;

    private List<Product> productList;
}
