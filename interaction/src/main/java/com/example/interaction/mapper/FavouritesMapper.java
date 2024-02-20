package com.example.interaction.mapper;

import com.example.interaction.dto.FavouritesDto;
import com.example.interaction.entity.Favourites;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavouritesMapper extends IEntityMapper<FavouritesDto, Favourites> {
}
