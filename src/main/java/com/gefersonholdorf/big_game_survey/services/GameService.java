package com.gefersonholdorf.big_game_survey.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gefersonholdorf.big_game_survey.dto.GameDTO;
import com.gefersonholdorf.big_game_survey.entities.Game;
import com.gefersonholdorf.big_game_survey.repositories.GameRepository;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameDTO::new).collect(Collectors.toList());
    }
    
}
