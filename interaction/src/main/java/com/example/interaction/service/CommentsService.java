package com.example.interaction.service;

import com.example.interaction.dto.CommentsDto;
import com.example.interaction.entity.Comments;
import com.example.interaction.exception.AddCommentsException;
import com.example.interaction.mapper.CommentsMapper;
import com.example.interaction.repository.CommentsRepository;
import com.example.interaction.response.CommentsResponse;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final CommentsMapper commentsMapper;

    public CommentsService(CommentsRepository commentsRepository, CommentsMapper commentsMapper) {
        this.commentsRepository = commentsRepository;
        this.commentsMapper = commentsMapper;
    }

    public CommentsResponse addComments(CommentsDto commentsDto) throws AddCommentsException {
        Comments comments=commentsMapper.toEntity(commentsDto);
        comments=commentsRepository.save(comments);
        if (comments==null){
            throw new AddCommentsException();
        }
        return CommentsResult(commentsMapper.toResource(comments));
    }

    private CommentsResponse CommentsResult(CommentsDto resource) {
    CommentsResponse commentsResponse=new CommentsResponse();
    commentsResponse.commentsDto=resource;
    return commentsResponse;
    }
}
