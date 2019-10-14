package com.tts.civics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String playerName;
	private Integer lastScore;
	private Integer totalGamesPlayed;
	private Integer percentageWon;
	
	public Player() {}

	public Player(String playerName, Integer lastScore, Integer totalGamesPlayed, Integer percentageWon) {
		this.playerName = playerName;
		this.lastScore = lastScore;
		this.totalGamesPlayed = totalGamesPlayed;
		this.percentageWon = percentageWon;
	}

	public Long getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getLastScore() {
		return lastScore;
	}

	public void setLastScore(Integer lastScore) {
		this.lastScore = lastScore;
	}

	public Integer getTotalGamesPlayed() {
		return totalGamesPlayed;
	}

	public void setTotalGamesPlayed(Integer totalGamesPlayed) {
		this.totalGamesPlayed = totalGamesPlayed;
	}

	public Integer getPercentageWon() {
		return percentageWon;
	}

	public void setPercentageWon(Integer percentageWon) {
		this.percentageWon = percentageWon;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", lastScore=" + lastScore
				+ ", totalGamesPlayed=" + totalGamesPlayed + ", percentageWon=" + percentageWon + "]";
	}	

}
