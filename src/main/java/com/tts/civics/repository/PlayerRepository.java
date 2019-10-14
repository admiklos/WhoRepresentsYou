package com.tts.civics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.civics.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	public List<Player> findAll();

	public Player findPlayerById(Long id);

}
