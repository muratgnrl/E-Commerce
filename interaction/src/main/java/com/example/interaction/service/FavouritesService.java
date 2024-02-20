package com.example.interaction.service;

import com.example.interaction.dto.FavouritesDto;
import com.example.interaction.entity.Favourites;
import com.example.interaction.exception.AddFavouritesException;
import com.example.interaction.mapper.FavouritesMapper;
import com.example.interaction.repository.FavouritesRepository;
import com.example.interaction.response.FavouritesResponse;
import org.springframework.stereotype.Service;

@Service
public class FavouritesService {
    private final FavouritesRepository repository;
    private final FavouritesMapper favouritesMapper;

    public FavouritesService(FavouritesRepository repository, FavouritesMapper favouritesMapper) {
        this.repository = repository;
        this.favouritesMapper = favouritesMapper;
    }

    public FavouritesResponse addFavourites(FavouritesDto favouritesDto) throws AddFavouritesException {
        Favourites favorites=favouritesMapper.toEntity(favouritesDto);
        favorites=repository.save(favorites);
        if (favorites==null){

            throw new AddFavouritesException();
        }
        return favouritesResult(favouritesMapper.toResource(favorites));
    }

    private FavouritesResponse favouritesResult(FavouritesDto resource) {
        FavouritesResponse favouritesResponse=new FavouritesResponse();
        favouritesResponse.favouritesDto=resource;
        return favouritesResponse;
    }
}
