package com.hyllcron.hfa.Services;

import com.hyllcron.hfa.Projections.GameMinProjection;
import com.hyllcron.hfa.dto.GameDTO;
import com.hyllcron.hfa.dto.GameMinDTO;
import com.hyllcron.hfa.entities.Game;
import com.hyllcron.hfa.repositories.GameRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServices {
    @Autowired
    private GameRepositorie gameRepositorie;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
       var result = gameRepositorie.findAll();
       List<GameMinDTO> dto  = result.stream().map(x -> new GameMinDTO(x)).toList();
       return dto;
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){
        Game result = gameRepositorie.findById(gameId).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection>result = gameRepositorie.searchByList(listId);
        List<GameMinDTO> dto  = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
