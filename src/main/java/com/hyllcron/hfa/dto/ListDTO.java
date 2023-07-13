package com.hyllcron.hfa.dto;

import com.hyllcron.hfa.entities.GameList;

public class ListDTO {

    private Long id;
    private String name;

    public ListDTO(){

    }

    public ListDTO(GameList entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
