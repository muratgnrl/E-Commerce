package com.example.interactionservice.mapper;

import com.example.interactionservice.dto.FavouritesDto;
import com.example.interactionservice.entity.Favourites;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FavouriteMapper extends IEntityMapper<FavouritesDto,Favourites>{
}
