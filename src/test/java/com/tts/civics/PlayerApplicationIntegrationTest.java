package com.tts.civics;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tts.civics.model.Player;
import com.tts.civics.repository.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = WhoRepresentsYouApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integrationtest.properties" )

public class PlayerApplicationIntegrationTest { 
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.setPlayerName("Tom Hanks");
		player.setLastScore(499);
		player.setPercentageWon(78);
		player.setTotalGamesPlayed(20);
		player = playerRepository.save(player);
	}

	@After
	public void tearDown() throws Exception {
		playerRepository.deleteAll();
	}

	@Test
	public void givenMemberId_getMember_returnsMember() throws Exception {
		Long id = player.getId();
		mvc.perform(
				get("/member/" + id).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.playerName", is("Tom Hanks")));
	}

	@Test
	public void findAll_returnAllMembers() throws Exception {
		mvc.perform(
				get("/members").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].playerName", is("Tom Hanks")));
	}

}
