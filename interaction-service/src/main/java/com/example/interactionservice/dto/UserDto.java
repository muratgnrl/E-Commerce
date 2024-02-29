package com.example.interactionservice.dto;



import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    public long userId;
    public String userName;
    public String userLastName;
    public List<CommentsDto> commentsList;

}
