package com.gefersonholdorf.big_game_survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gefersonholdorf.big_game_survey.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
