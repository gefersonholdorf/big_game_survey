package com.gefersonholdorf.big_game_survey.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Game_RecordInsertDTO {
    
    private String name;
    private Integer age;
    private Long game_id;

}
