package com.hyllcron.hfa.repositories;

import com.hyllcron.hfa.Projections.GameMinProjection;
import com.hyllcron.hfa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepositorie extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
		SELECT Games.id, Games.title, Games.game_year AS gameYear, Games.img_url AS imgUrl,
		Games.short_description AS shortDescription, tb_belonging.position
		FROM Games
		INNER JOIN tb_belonging ON Games.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
