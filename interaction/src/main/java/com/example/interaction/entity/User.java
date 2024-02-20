package com.example.interaction.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userLastName;
    @OneToMany(mappedBy = "user")
    private List<Comments> commentsList;

    public User() {
    }

    public User(int userId, String userName, String userLastName, List<Comments> commentsList) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.commentsList = commentsList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }
}
