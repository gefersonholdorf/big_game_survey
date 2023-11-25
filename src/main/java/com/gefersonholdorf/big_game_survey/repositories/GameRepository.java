package com.gefersonholdorf.big_game_survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gefersonholdorf.big_game_survey.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    
}
