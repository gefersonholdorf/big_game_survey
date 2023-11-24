package com.gefersonholdorf.big_game_survey.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gefersonholdorf.big_game_survey.entities.Game_Record;

public interface Game_RecordRepository extends JpaRepository<Game_Record, Long>{
    
    @Query("SELECT obj FROM Record obj WHERE "
			+ "(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND "
			+ "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
	Page<Game_Record> findByMoments(Instant min, Instant max, Pageable pageable);
}
