package com.example.interaction.dto;

import com.example.interaction.entity.Comments;
import com.example.interaction.entity.Favourites;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ProductDto {
    public int productId;
    public String productName;
    public String productDescprition;

    public Favourites favorite;

    public List<Comments> commentsList;
}
