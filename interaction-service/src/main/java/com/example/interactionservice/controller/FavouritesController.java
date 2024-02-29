package com.example.interactionservice.controller;

import com.example.interactionservice.dto.FavouritesDto;
import com.example.interactionservice.exception.AddFavouritesException;
import com.example.interactionservice.exception.FavouritesDeleteException;
import com.example.interactionservice.exception.FavouritesNotFoundException;
import com.example.interactionservice.response.FavouritesResponse;
import com.example.interactionservice.service.ımpl.FavouritesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourites")
public class FavouritesController {

    private final FavouritesServiceImpl favouritesService;

    public FavouritesController(FavouritesServiceImpl favouritesService) {
        this.favouritesService = favouritesService;
    }
    @PostMapping("/addFavourites")
    public ResponseEntity<Object> addFavourites(@RequestBody FavouritesDto favouritesDto) throws AddFavouritesException {
        FavouritesResponse addFavourites = favouritesService.addFavourites(favouritesDto);
        return ResponseEntity.ok(addFavourites);
    }
    @GetMapping("/allFavourites")
    public List<FavouritesDto> getAllFavourites(){
        List<FavouritesDto> getAllFavourites = favouritesService.getAllFavourites();
        return getAllFavourites;
    }
    @DeleteMapping("/deleted/{favoriteId}")
    public ResponseEntity<FavouritesResponse> deleteFavourites(@PathVariable (value = "favoriteId") long favoriteId) throws FavouritesDeleteException {
        FavouritesResponse deleteFavourites = favouritesService.deleteFavourites(favoriteId);
        return ResponseEntity.ok(deleteFavourites);


    }@GetMapping("/find/{favoriteId}")
    private ResponseEntity<FavouritesResponse> findFavourites(@PathVariable (value = "favoriteId") long favoriteId) throws FavouritesNotFoundException {
        FavouritesResponse findFavourites = favouritesService.findFavourite(favoriteId);
        return ResponseEntity.ok(findFavourites);
    }
}
