package com.hyllcron.hfa.Services;

import com.hyllcron.hfa.dto.GameMinDTO;
import com.hyllcron.hfa.entities.Game;
import com.hyllcron.hfa.repositories.GameRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameServices {
    @Autowired
    private GameRepositorie gameRepositorie;

    public List<GameMinDTO> findAll(){
       var result = gameRepositorie.findAll();
       List<GameMinDTO> dto  = result.stream().map(x -> new GameMinDTO(x)).toList();
       return dto;
    }
}
