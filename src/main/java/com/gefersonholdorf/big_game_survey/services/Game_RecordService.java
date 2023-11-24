package com.gefersonholdorf.big_game_survey.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.big_game_survey.dto.Game_RecordDTO;
import com.gefersonholdorf.big_game_survey.dto.Game_RecordInsertDTO;
import com.gefersonholdorf.big_game_survey.entities.Game;
import com.gefersonholdorf.big_game_survey.entities.Game_Record;
import com.gefersonholdorf.big_game_survey.repositories.GameRepository;
import com.gefersonholdorf.big_game_survey.repositories.Game_RecordRepository;

@Service
public class Game_RecordService {
    
    @Autowired
    private Game_RecordRepository game_RecordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public Game_RecordDTO insert(Game_RecordInsertDTO dto) {
        Game_Record entity = new Game_Record();
        entity.setName(dto.getName());
        entity.setMoment(Instant.now());
        entity.setAge(dto.getAge());

        Game game = gameRepository.getOne(dto.getGame_id());
        entity.setGame(game);

        entity = game_RecordRepository.save(entity);
        return new Game_RecordDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<Game_RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest) {
        return game_RecordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new Game_RecordDTO(x));
    }

}
