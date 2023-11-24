package com.gefersonholdorf.big_game_survey.dto;

import com.gefersonholdorf.big_game_survey.entities.Game;
import com.gefersonholdorf.big_game_survey.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {
    
    private Long id;
    private String title;
    private Platform platform;

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.platform = entity.getPlatform();
    }
}
