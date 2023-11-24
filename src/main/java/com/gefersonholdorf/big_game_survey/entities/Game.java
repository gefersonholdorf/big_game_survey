package com.gefersonholdorf.big_game_survey.entities;

import java.util.ArrayList;
import java.util.List;

import com.gefersonholdorf.big_game_survey.enums.Platform;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Platform platform;

    @ManyToOne 
    @JoinColumn (name = "genre_id")
    private Genre genre;
    
    @OneToMany (mappedBy = "game")
    private List<Game_Record> records = new ArrayList<>();
}
