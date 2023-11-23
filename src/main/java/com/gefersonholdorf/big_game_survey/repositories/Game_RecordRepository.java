package com.gefersonholdorf.big_game_survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gefersonholdorf.big_game_survey.entities.Game_Record;

public interface Game_RecordRepository extends JpaRepository<Game_Record, Long>{
    
}
