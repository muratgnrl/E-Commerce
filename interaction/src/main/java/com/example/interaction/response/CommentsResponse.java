package com.example.interaction.response;

import com.example.interaction.dto.CommentsDto;

import java.io.Serializable;

public class CommentsResponse extends BaseResponse implements Serializable {
    public CommentsDto commentsDto;
}
