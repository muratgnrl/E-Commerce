package com.example.interaction.dto;

import com.example.interaction.entity.Product;
import com.example.interaction.entity.User;


import java.io.Serializable;

public class CommentsDto implements Serializable {

    private int commentId;
    private String comment;

    private int productId;

    private User user;
}
