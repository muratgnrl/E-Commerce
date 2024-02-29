package com.example.interactionservice.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Favourites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteId;

    private String favoriteDesc;
    @OneToMany(mappedBy = "favourites")
    private List<Product> productList;

    public long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteDesc() {
        return favoriteDesc;
    }

    public void setFavoriteDesc(String favoriteDesc) {
        this.favoriteDesc = favoriteDesc;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Favourites(long favoriteId, String favoriteDesc, List<Product> productList) {
        this.favoriteId = favoriteId;
        this.favoriteDesc = favoriteDesc;
        this.productList = productList;
    }

    public Favourites() {
    }
}
