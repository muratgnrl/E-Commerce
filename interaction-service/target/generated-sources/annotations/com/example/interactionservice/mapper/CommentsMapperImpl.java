package com.example.interactionservice.mapper;

import com.example.interactionservice.dto.CommentsDto;
import com.example.interactionservice.entity.Comments;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-26T14:32:13+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CommentsMapperImpl implements CommentsMapper {

    @Override
    public CommentsDto toDto(Comments e) {
        if ( e == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.commentId = e.getCommentId();
        commentsDto.comment = e.getComment();
        commentsDto.user = e.getUser();

        return commentsDto;
    }

    @Override
    public Comments toEntity(CommentsDto r) {
        if ( r == null ) {
            return null;
        }

        Comments comments = new Comments();

        comments.setCommentId( r.commentId );
        comments.setComment( r.comment );
        comments.setUser( r.user );

        return comments;
    }

    @Override
    public List<CommentsDto> toDto(List<Comments> eList) {
        if ( eList == null ) {
            return null;
        }

        List<CommentsDto> list = new ArrayList<CommentsDto>( eList.size() );
        for ( Comments comments : eList ) {
            list.add( toDto( comments ) );
        }

        return list;
    }

    @Override
    public List<Comments> toEntity(List<CommentsDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Comments> list = new ArrayList<Comments>( rList.size() );
        for ( CommentsDto commentsDto : rList ) {
            list.add( toEntity( commentsDto ) );
        }

        return list;
    }
}
