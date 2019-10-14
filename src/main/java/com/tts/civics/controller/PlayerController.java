package com.tts.civics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tts.civics.model.Player;
import com.tts.civics.service.PlayerServiceImpl;

@RestController
public class PlayerController {
	
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	@CrossOrigin
	@GetMapping("/")
	public String index() {
		// https://api.propublica.org/congress/v1/members/W000817.json
		// https://api.propublica.org/congress/v1/members/W000817/statements/116.json
		// https://api.propublica.org/congress/v1/members/W000817/bills/introduced.json
		// https://api.propublica.org/congress/v1/members/W000817/office_expenses/2017/4.json
		return "Want to play a game?";
	}
		
	@CrossOrigin
	@GetMapping("/players") 
	public List<Player> getAllPlayers() {
		return playerServiceImpl.getAllPlayers();
	}
	
	@CrossOrigin
	@GetMapping("/player/{id}") 
	public Player getPlayerById(@PathVariable Long id) {
		return playerServiceImpl.getPlayerById(id);
	}
	
	@CrossOrigin
	@PostMapping("/player")
	public void postPlayer(@RequestBody Player player) {
		playerServiceImpl.postPlayer(player);
	}
	
	@CrossOrigin
	@PutMapping("/player/{id}")
	public void updateMember(@PathVariable Long id, @RequestBody Player player) {
		playerServiceImpl.updatePlayer(id,  player);
	}
	
	@CrossOrigin
	@DeleteMapping("/players") 
	public void deleteAllPlayers() {
		playerServiceImpl.deleteAllPlayers();
	}
	
	@CrossOrigin
	@DeleteMapping("/player/{id}") 
	public void deletePlayer(@PathVariable Long id) {
		playerServiceImpl.deletePlayer(id);
	}
	
}
