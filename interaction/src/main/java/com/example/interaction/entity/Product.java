package com.example.interaction.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productDescprition;
    @ManyToOne
    @JoinColumn(name = "favoriteId")
    private Favourites  favorite;

    @OneToMany(mappedBy = "product")
    private List<Comments> commentsList;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescprition() {
        return productDescprition;
    }

    public void setProductDescprition(String productDescprition) {
        this.productDescprition = productDescprition;
    }

    public Favourites getFavorite() {
        return favorite;
    }

    public void setFavorite(Favourites favorite) {
        this.favorite = favorite;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Product(int productId, String productName, String productDescprition, Favourites favorite, List<Comments> commentsList) {
        this.productId = productId;
        this.productName = productName;
        this.productDescprition = productDescprition;
        this.favorite = favorite;
        this.commentsList = commentsList;
    }

    public Product() {
    }
}
