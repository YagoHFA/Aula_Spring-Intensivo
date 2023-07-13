package com.hyllcron.hfa.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BeLonginPk {
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BeLonginPk(){

    }

    public BeLonginPk(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeLonginPk that)) return false;

        if (getGame() != null ? !getGame().equals(that.getGame()) : that.getGame() != null) return false;
        return getList() != null ? getList().equals(that.getList()) : that.getList() == null;
    }

    @Override
    public int hashCode() {
        int result = getGame() != null ? getGame().hashCode() : 0;
        result = 31 * result + (getList() != null ? getList().hashCode() : 0);
        return result;
    }
}
