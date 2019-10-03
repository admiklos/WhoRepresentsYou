package com.tts.civics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.civics.model.CongressPerson;
import com.tts.civics.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberServiceInt {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<CongressPerson> getAllMembers() {
		return memberRepository.findAll();
	}
	
	@Override
	public CongressPerson getMemberById(Long id) {
		return memberRepository.findMemberById(id);
	}
	
	@Override
	public void postMember(CongressPerson member) {
		memberRepository.save(member);
	}
	
	@Override
	public void updateMember(Long id, CongressPerson member) {
		CongressPerson updatedMember = memberRepository.findMemberById(id);

		updatedMember.setMemberId(member.getMemberId());
		updatedMember.setTheName(member.getTheName());
		updatedMember.setDob(member.getDob());
		updatedMember.setTheState(member.getTheState());
		updatedMember.setaPhoto(member.getaPhoto());
		updatedMember.setWhichChamber(member.getWhichChamber());
		updatedMember.setWhichParty(member.getWhichParty());
		updatedMember.setUrl(member.getUrl());
		updatedMember.setIsNewMember(member.getIsNewMember());
		updatedMember.setIsLeavingOffice(member.getIsLeavingOffice());
		updatedMember.setNumYearsInOffice(member.getNumYearsInOffice());		
		updatedMember.setNumBillsSponsored(member.getNumBillsSponsored());
		updatedMember.setVotesWithPartyPercent(member.getVotesWithPartyPercent());
		updatedMember.setMissedVotesPercent(member.getMissedVotesPercent());
		updatedMember.setTravelExpenses(member.getTravelExpenses());
		updatedMember.setOfficeExpenses(member.getOfficeExpenses());
		updatedMember.setTwitter(member.getTwitter());
		updatedMember.setFacebook(member.getFacebook());
		updatedMember.setYoutube(member.getYoutube());
		
		memberRepository.save(updatedMember);
	}
	
	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	@Override
	public void deleteAllMembers() {
		memberRepository.deleteAll();
	}

}
