package com.tts.civics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.civics.model.Player;
import com.tts.civics.repository.PlayerRepository;
import com.tts.civics.service.PlayerServiceImpl;
import com.tts.civics.service.PlayerServiceInt;

@RunWith(SpringRunner.class)
public class PlayerServiceTest {
	
	@Configuration
	static class ServiceConfiguration {
		@Bean
		public PlayerServiceInt configuration() {
			return new PlayerServiceImpl();
		}
	}
	
	@Autowired
	PlayerServiceInt playerService;
	
	@MockBean
	PlayerRepository playerRepository;
	
	private static Player player;
	private static List<Player> players;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.setPlayerName("Tom Hanks");
		player.setLastScore(499);
		player.setPercentageWon(78);
		player.setTotalGamesPlayed(20);
		player = playerRepository.save(player);
		players = new ArrayList<>();
		players.add(player);
		player = new Player();
		player.setPlayerName("Lilly Tomlin");
		player.setLastScore(33);
		player.setPercentageWon(44);
		player.setTotalGamesPlayed(4);
		player = playerRepository.save(player);
		players.add(player);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void givenMemberId_returnMember() {
		Mockito.when(playerRepository.findPlayerById(1L)).thenReturn(player);		
		Player found = playerRepository.findPlayerById(1L);	
		assertThat(player).isEqualToComparingFieldByField(found);
	}
	
	@Test
	public void ifFindAll_returnStudents() {
		Mockito.when(playerRepository.findAll()).thenReturn(players);
		List<Player> actual = playerService.getAllPlayers();
		assertEquals(players, actual);
	}
}
