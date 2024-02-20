package com.example.interaction.dto;



import java.io.Serializable;
import java.util.List;

public class UserDto  implements Serializable {
    public int userId;
    public String userName;
    public String userLastName;
    public List<CommentsDto> commentsList;

}
