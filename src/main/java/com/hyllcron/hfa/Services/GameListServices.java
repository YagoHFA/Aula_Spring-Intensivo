package com.hyllcron.hfa.Services;



import com.hyllcron.hfa.dto.ListDTO;
import com.hyllcron.hfa.entities.GameList;
import com.hyllcron.hfa.repositories.GameListRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServices {
    @Autowired
    private GameListRepositorie gameListRepositorie;

    @Transactional(readOnly = true)
    public List<ListDTO> findAll(){
       List<GameList> result = gameListRepositorie.findAll();
       return result.stream().map(x -> new ListDTO(x)).toList();

    }

}
