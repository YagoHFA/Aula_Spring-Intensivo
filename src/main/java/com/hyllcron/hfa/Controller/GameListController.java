package com.hyllcron.hfa.Controller;

import com.hyllcron.hfa.Services.GameListServices;
import com.hyllcron.hfa.Services.GameServices;
import com.hyllcron.hfa.dto.GameDTO;
import com.hyllcron.hfa.dto.GameMinDTO;
import com.hyllcron.hfa.dto.ListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListServices gameListServices;

    @GetMapping
    public List<ListDTO> findAll(){
        List<ListDTO> result = gameListServices.findAll();
        return result;
    }
}
