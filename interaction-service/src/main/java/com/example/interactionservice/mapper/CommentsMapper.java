package com.example.interactionservice.mapper;

import com.example.interactionservice.dto.CommentsDto;
import com.example.interactionservice.entity.Comments;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CommentsMapper extends IEntityMapper<CommentsDto, Comments> {
}
