package com.example.interaction.repository;

import com.example.interaction.entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouritesRepository extends JpaRepository<Favourites,Integer> {
}
