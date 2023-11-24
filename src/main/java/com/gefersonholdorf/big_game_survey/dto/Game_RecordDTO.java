package com.gefersonholdorf.big_game_survey.dto;

import java.time.Instant;

import com.gefersonholdorf.big_game_survey.entities.Game_Record;
import com.gefersonholdorf.big_game_survey.enums.Platform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Game_RecordDTO {

    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;

    public Game_RecordDTO(Game_Record entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.gameTitle = entity.getGame().getTitle();
        this.gamePlatform = entity.getGame().getPlatform();
        this.genreName = entity.getGame().getGenre().getName();
    }
}
