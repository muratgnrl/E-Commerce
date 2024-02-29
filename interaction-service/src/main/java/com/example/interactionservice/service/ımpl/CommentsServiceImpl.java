package com.example.interactionservice.service.ımpl;

import com.example.interactionservice.dto.CommentsDto;
import com.example.interactionservice.entity.Comments;
import com.example.interactionservice.exception.AddCommentsException;
import com.example.interactionservice.exception.CommentsNotDeletedException;
import com.example.interactionservice.mapper.CommentsMapper;
import com.example.interactionservice.repository.CommentsRepository;
import com.example.interactionservice.response.CommentsResponse;
import com.example.interactionservice.response.Meta;
import com.example.interactionservice.service.CommentsService;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {
    private final CommentsRepository commentsRepository;
    private final CommentsMapper commentsMapper;

    public CommentsServiceImpl(CommentsRepository commentsRepository, CommentsMapper commentsMapper) {
        this.commentsRepository = commentsRepository;
        this.commentsMapper = commentsMapper;
    }

    @Override
    public CommentsResponse addComments(CommentsDto commentsDto) throws AddCommentsException {
        Comments comments= commentsMapper.toEntity(commentsDto);
        comments=commentsRepository.save(comments);
        if (comments ==null){
            throw new AddCommentsException();
        }
        return commentsResult(commentsMapper.toDto(comments));
    }

    @Override
    public CommentsResponse deleteComment(long commentId) throws CommentsNotDeletedException {
        Comments comments = commentsRepository.findById(commentId).orElse(null);
        if (comments==null){
            throw new CommentsNotDeletedException();
        }else {
            CommentsResponse response  =new CommentsResponse();
            commentsRepository.delete(comments);
            response.commentsDto=commentsMapper.toDto(comments);
            response.meta=new Meta(200,"Yorum silindi");
            return response;
        }
    }

    private CommentsResponse commentsResult(CommentsDto dto) {
        CommentsResponse commentsResponse =new CommentsResponse();
        commentsResponse.meta=new Meta(200,"Yorum eklendi");
        commentsResponse.commentsDto=dto;
        return commentsResponse;
    }


}
