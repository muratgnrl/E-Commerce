package com.example.interaction.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Favourites  {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)

    private int favoriteId;
    private String favoriteDesc;

    @OneToMany(mappedBy = "favourites")
    private List<Product> productList;

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
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

    public Favourites() {
    }

    public Favourites(int favoriteId, String favoriteDesc, List<Product> productList) {
        this.favoriteId = favoriteId;
        this.favoriteDesc = favoriteDesc;
        this.productList = productList;
    }
}
