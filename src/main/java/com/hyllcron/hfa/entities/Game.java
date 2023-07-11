package com.hyllcron.hfa.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "game_year")
    private Integer year;
    private String genere;
    private String plataform;
    private String imUrl;
    private String shortDescripition;
    private String longDescription;

    public Game(){

    }

    public Game(long id, String title, Integer year, String genere, String plataform, String imUrl,
                String shortDescripition, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genere = genere;
        this.plataform = plataform;
        this.imUrl = imUrl;
        this.shortDescripition = shortDescripition;
        this.longDescription = longDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getPlataform() {
        return plataform;
    }

    public void setPlataform(String plataform) {
        this.plataform = plataform;
    }

    public String getImUrl() {
        return imUrl;
    }

    public void setImUrl(String imUrl) {
        this.imUrl = imUrl;
    }

    public String getShortDescripition() {
        return shortDescripition;
    }

    public void setShortDescripition(String shortDescripition) {
        this.shortDescripition = shortDescripition;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;

        return getId() == game.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
