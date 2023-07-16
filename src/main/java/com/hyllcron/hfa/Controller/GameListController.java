package com.hyllcron.hfa.Controller;

import com.hyllcron.hfa.Services.GameListServices;
import com.hyllcron.hfa.Services.GameServices;
import com.hyllcron.hfa.dto.GameDTO;
import com.hyllcron.hfa.dto.GameMinDTO;
import com.hyllcron.hfa.dto.ListDTO;
import com.hyllcron.hfa.dto.ReplacementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListServices gameListServices;

    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<ListDTO> findAll(){
        List<ListDTO> result = gameListServices.findAll();
        return result;
    }


    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameServices.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/games/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListServices.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
}
