package com.example.interactionservice.service.ımpl;

import com.example.interactionservice.dto.FavouritesDto;
import com.example.interactionservice.dto.UserDto;
import com.example.interactionservice.entity.Favourites;
import com.example.interactionservice.exception.AddFavouritesException;
import com.example.interactionservice.exception.FavouritesDeleteException;
import com.example.interactionservice.exception.FavouritesNotFoundException;
import com.example.interactionservice.mapper.FavouriteMapper;
import com.example.interactionservice.repository.FavouritesRepository;
import com.example.interactionservice.response.FavouritesResponse;
import com.example.interactionservice.response.Meta;
import com.example.interactionservice.service.FavouritesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouritesServiceImpl  implements FavouritesService {
    private final FavouritesRepository favouritesRepository;
    private final FavouriteMapper favouriteMapper;

    public FavouritesServiceImpl(FavouritesRepository favouritesRepository, FavouriteMapper favouriteMapper) {
        this.favouritesRepository = favouritesRepository;
        this.favouriteMapper = favouriteMapper;
    }


    @Override
    public FavouritesResponse addFavourites(FavouritesDto favouritesDto) throws AddFavouritesException {
        Favourites favourites = favouriteMapper.toEntity(favouritesDto);
        favourites = favouritesRepository.save(favourites);
        if (favourites == null) {
            throw new AddFavouritesException();
        }
        return favouritesResult(favouriteMapper.toDto(favourites));
    }

    private FavouritesResponse favouritesResult(FavouritesDto dto) {
        FavouritesResponse favouritesResponse = new FavouritesResponse();
        favouritesResponse.meta = new Meta(200, "Ürün favorilere eklendi");
        favouritesResponse.dto = dto;
        return favouritesResponse;
    }


    @Override
    public List<FavouritesDto> getAllFavourites() {
        List<FavouritesDto> favouritesDtos = new ArrayList<>();

        Iterable<Favourites> favourites = favouritesRepository.findAll();

        for (Favourites favourite : favourites) {
            FavouritesDto favouritesDto = favouriteMapper.toDto(favourite);
            favouritesDtos.add(favouritesDto);

        }
        return favouritesDtos;
    }

    @Override
    public FavouritesResponse findFavourite(long favoriteId) throws FavouritesNotFoundException {
        Favourites favourites = favouritesRepository.findById(favoriteId).orElse(null);
        if (favourites != null) {
            FavouritesResponse favouritesResponse = new FavouritesResponse();
            favouritesResponse.meta = new Meta(200, "Favorilere eklenen obje bulundu  = " + favoriteId);
            favouritesResponse.dto = favouriteMapper.toDto(favourites);
            return favouritesResponse;
        } else {
            throw new FavouritesNotFoundException();
        }
    }

    public FavouritesResponse deleteFavourites(long favoriteId) throws FavouritesDeleteException {
        Favourites favourites = favouritesRepository.findById(favoriteId).orElse(null);
        if (favourites != null) {
            FavouritesResponse response = new FavouritesResponse();
            response.dto = favouriteMapper.toDto(favourites);
            favouritesRepository.delete(favourites);
            response.meta = new Meta(200, "Favori silindi: " + favoriteId);
            return response;
        } else {
            throw new FavouritesDeleteException();
            }
        }
    }
