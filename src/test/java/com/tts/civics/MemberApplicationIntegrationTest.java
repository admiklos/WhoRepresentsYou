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

import com.tts.civics.model.Member;
import com.tts.civics.model.Member.ChamberEnum;
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
	
	private Member member;

	@Before
	public void setUp() throws Exception {
		Member member = new Member();
		member.setName("Elizabeth Warren");
		member.setPhoto("https://theunitedstates.io/images/congress/original/W000817.jpg");
		member.setWhichChamber(ChamberEnum.SENATE);
		member.setState("MA");
		member.setIsNewMember(false);
		member.setIsLeavingOffice(false);
		member.setNumYearsInOffice(20);
		member.setStatements("Warren, Pocan, and Ocasio-Cortez Investigate...");
        member.setBillsIntroduced("A bill to direct the Administrator of the Federal Aviation Administration ...");
        member.setOfficeExpenses(-1.0);
        member.setTravelExpenses(-1.0);
		memberRepository.save(member);
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
					.andExpect(jsonPath("$.name", is("Elizabeth Warren")));
	}

	@Test
	public void findAll_returnAllMembers() throws Exception {
		mvc.perform(
				get("/members").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].name", is("Elizabeth Warren")));
	}

}
