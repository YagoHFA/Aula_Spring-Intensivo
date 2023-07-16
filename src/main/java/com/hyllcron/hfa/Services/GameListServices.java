package com.hyllcron.hfa.Services;



import com.hyllcron.hfa.Projections.GameMinProjection;
import com.hyllcron.hfa.dto.ListDTO;
import com.hyllcron.hfa.entities.GameList;
import com.hyllcron.hfa.repositories.GameListRepositorie;
import com.hyllcron.hfa.repositories.GameRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServices {
    @Autowired
    private GameListRepositorie gameListRepositorie;

    @Autowired
    private GameRepositorie gameRepositorie;

    @Transactional(readOnly = true)
    public List<ListDTO> findAll(){
       List<GameList> result = gameListRepositorie.findAll();
       return result.stream().map(x -> new ListDTO(x)).toList();


    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list  = gameRepositorie.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex: destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex: sourceIndex;

        for (int i = min; i<= max;i++){
            gameListRepositorie.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
    }

}
