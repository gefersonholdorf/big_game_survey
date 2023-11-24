package com.gefersonholdorf.big_game_survey.resources;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.big_game_survey.dto.Game_RecordDTO;
import com.gefersonholdorf.big_game_survey.dto.Game_RecordInsertDTO;
import com.gefersonholdorf.big_game_survey.services.Game_RecordService;

@RestController
@RequestMapping(value = "/records")
public class Game_RecordResource {

    @Autowired
    private Game_RecordService game_RecordService;

    @PostMapping
    public ResponseEntity<Game_RecordDTO> insert (@RequestBody Game_RecordInsertDTO dto) {
        Game_RecordDTO newDTO = game_RecordService.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }

    @GetMapping 
    public ResponseEntity<Page<Game_RecordDTO>> findAll (
                @RequestParam(value = "min", defaultValue = "") String min,
                @RequestParam(value = "max", defaultValue = "") String max,
                @RequestParam(value = "page", defaultValue = "0") Integer page,
                @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
                @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
                @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

            Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
            Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

            if(linesPerPage == 0) {
                linesPerPage = Integer.MAX_VALUE;
            }

            PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

            Page<Game_RecordDTO> list = game_RecordService.findByMoment(minDate, maxDate, pageRequest);

            return ResponseEntity.ok().body(list);
    }
    
}
