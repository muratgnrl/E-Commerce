package com.example.interactionservice.response;

import com.example.interactionservice.dto.CommentsDto;

import java.io.Serializable;

public class CommentsResponse extends BaseResponse implements Serializable {
    public CommentsDto commentsDto;
}
