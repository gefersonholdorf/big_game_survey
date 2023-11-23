package com.gefersonholdorf.big_game_survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gefersonholdorf.big_game_survey.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    
}
