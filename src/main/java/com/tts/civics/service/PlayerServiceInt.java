package com.tts.civics.service;

import java.util.List;

import com.tts.civics.model.Player;

public interface PlayerServiceInt {

	public List<Player> getAllPlayers();

	public Player getPlayerById(Long id);

	void postPlayer(Player player);

	void deletePlayer(Long id);

	void deleteAllPlayers();

	void updatePlayer(Long id, Player player);

}
