package com.hyllcron.hfa.repositories;

import com.hyllcron.hfa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepositorie extends JpaRepository<Game, Long> {

}
