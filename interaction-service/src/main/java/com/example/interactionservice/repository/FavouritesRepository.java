package com.example.interactionservice.repository;

import com.example.interactionservice.entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouritesRepository extends JpaRepository<Favourites,Long> {


}
