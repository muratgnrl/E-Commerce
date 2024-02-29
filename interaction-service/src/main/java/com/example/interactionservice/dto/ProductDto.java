package com.example.interactionservice.dto;

import com.example.interactionservice.entity.Favourites;


import java.io.Serializable;
import java.util.List;

public class ProductDto implements Serializable {
    public long productId;
    public String productName;
    public String productDescprition;
    public Favourites favourites;
    public List<CommentsDto> commentsList;
}
