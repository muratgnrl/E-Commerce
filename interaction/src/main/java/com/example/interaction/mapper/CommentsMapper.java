package com.example.interaction.mapper;

import com.example.interaction.dto.CommentsDto;
import com.example.interaction.entity.Comments;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentsMapper extends IEntityMapper<CommentsDto, Comments>{
}
