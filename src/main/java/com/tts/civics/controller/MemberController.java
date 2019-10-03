package com.tts.civics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.civics.model.CongressPerson;
import com.tts.civics.service.MemberServiceImpl;

@RestController
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	@GetMapping("/")
	public String index() {
		// https://api.propublica.org/congress/v1/members/W000817.json
		// https://api.propublica.org/congress/v1/members/W000817/statements/116.json
		// https://api.propublica.org/congress/v1/members/W000817/bills/introduced.json
		// https://api.propublica.org/congress/v1/members/W000817/office_expenses/2017/4.json
		return "Want to play a game?";
	}
		
	@GetMapping("/members") 
	public List<CongressPerson> getAllMembers() {
		return memberServiceImpl.getAllMembers();
	}
	
	@GetMapping("/member/{id}") 
	public CongressPerson getMemberById(@PathVariable Long id) {
		return memberServiceImpl.getMemberById(id);
	}
	
	@PostMapping("/member")
	public void postMember(CongressPerson member) {
		memberServiceImpl.postMember(member);
	}
	
	@PutMapping("/member/{id}")
	public void updateMember(@PathVariable Long id, CongressPerson member) {
		memberServiceImpl.updateMember(id,  member);
	}
	
	@DeleteMapping("/members") 
	public void deleteAllMembers() {
		memberServiceImpl.deleteAllMembers();
	}
	
	@DeleteMapping("/member/{id}") 
	public void deleteMember(@PathVariable Long id) {
		memberServiceImpl.deleteMember(id);
	}
	
}
