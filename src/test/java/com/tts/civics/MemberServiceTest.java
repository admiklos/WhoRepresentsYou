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

import com.tts.civics.model.Member;
import com.tts.civics.model.Member.ChamberEnum;
import com.tts.civics.repository.MemberRepository;
import com.tts.civics.service.MemberServiceImpl;
import com.tts.civics.service.MemberServiceInt;

@RunWith(SpringRunner.class)
public class MemberServiceTest {
	
	@Configuration
	static class ServiceConfiguration {
		@Bean
		public MemberServiceInt configuration() {
			return new MemberServiceImpl();
		}
	}
	
	@Autowired
	MemberServiceInt memberService;
	
	@MockBean
	MemberRepository memberRepository;
	
	private static Member member;
	private static List<Member> members;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		member = new Member();
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
		members = new ArrayList<>();
		members.add(member);
		member.setName("Bernie Sanders");
		member.setState("AZ");
		member.setNumYearsInOffice(50);
		members.add(member);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void givenMemberId_returnMember() {
		Mockito.when(memberRepository.findMemberById(1L)).thenReturn(member);		
		Member found = memberRepository.findMemberById(1L);	
		assertThat(member).isEqualToComparingFieldByField(found);
	}
	
	@Test
	public void ifFindAll_returnStudents() {
		Mockito.when(memberRepository.findAll()).thenReturn(members);
		List<Member> actual = memberService.getAllMembers();
		assertEquals(members, actual);
	}
}
