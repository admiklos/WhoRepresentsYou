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

import com.tts.civics.model.CongressPerson;
import com.tts.civics.model.CongressPerson.ChamberEnum;
import com.tts.civics.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = WhoRepresentsYouApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integrationtest.properties" )

public class MemberApplicationIntegrationTest { 
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private CongressPerson member;

	@Before
	public void setUp() throws Exception {
		member = new CongressPerson();
		member.setMemberId("W000817");
		member.setTheName("Elizabeth Warren");
		member.setDob("1949-06-22");
		member.setTheState("MASSACHUSETTS");
		member.setaPhoto("https://theunitedstates.io/images/congress/original/W000817.jpg");
		member.setWhichChamber(ChamberEnum.SENATE);
		member.setWhichParty("Democrat");
		member.setUrl("https://www.warren.senate.gov");
		member.setIsNewMember(false);
		member.setIsLeavingOffice(false);
		member.setNumYearsInOffice(20);		
		member.setNumBillsSponsored(40);
		member.setVotesWithPartyPercent(73.98);
		member.setMissedVotesPercent(37.38);
		member.setTravelExpenses(-1.0);
		member.setOfficeExpenses(-1.0);
		member.setTwitter("SenWarren");
		member.setFacebook("senatorelizabethwarren");
		member.setYoutube("senelizabethwarren");
		member = memberRepository.save(member);
	}

	@After
	public void tearDown() throws Exception {
		memberRepository.deleteAll();
	}

	@Test
	public void givenMemberId_getMember_returnsMember() throws Exception {
		Long id = member.getId();
		mvc.perform(
				get("/member/" + id).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.theName", is("Elizabeth Warren")));
	}

	@Test
	public void findAll_returnAllMembers() throws Exception {
		mvc.perform(
				get("/members").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].theName", is("Elizabeth Warren")));
	}

}
