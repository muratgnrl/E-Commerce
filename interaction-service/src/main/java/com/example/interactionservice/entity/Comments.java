package com.example.interactionservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "yorum")
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;
    @Column(name = "yorum")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public Comments() {
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Comments(long commentId, String comment, User user, Product product) {
        this.commentId = commentId;
        this.comment = comment;
        this.user = user;
        this.product = product;
    }
}
