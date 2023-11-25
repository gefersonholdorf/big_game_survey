package com.gefersonholdorf.big_game_survey.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gefersonholdorf.big_game_survey.entities.Game_Record;

@Repository
public interface Game_RecordRepository extends JpaRepository<Game_Record, Long>{
    
   @Query("SELECT obj FROM Game_Record obj WHERE "
        + "(:min IS NULL OR obj.moment >= :min) AND "
        + "(:max IS NULL OR obj.moment <= :max)")
Page<Game_Record> findByMoments(@Param("min") Instant min, @Param("max") Instant max, Pageable pageable);
}
