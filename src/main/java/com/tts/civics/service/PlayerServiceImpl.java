package com.tts.civics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.civics.model.Player;
import com.tts.civics.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerServiceInt {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	@Override
	public Player getPlayerById(Long id) {
		return playerRepository.findPlayerById(id);
	}
	
	@Override
	public void postPlayer(Player player) {
		playerRepository.save(player);
	}
	
	@Override
	public void updatePlayer(Long id, Player player) {
		Player updatedPlayer = playerRepository.findPlayerById(id);

		updatedPlayer.setPlayerName(player.getPlayerName());
		updatedPlayer.setLastScore(player.getLastScore());
		updatedPlayer.setTotalGamesPlayed(player.getTotalGamesPlayed());
		updatedPlayer.setPercentageWon(player.getPercentageWon());
		
		playerRepository.save(updatedPlayer);
	}
	
	@Override
	public void deletePlayer(Long id) {
		playerRepository.deleteById(id);
	}

	@Override
	public void deleteAllPlayers() {
		playerRepository.deleteAll();
	}

}
