package com.tts.civics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.civics.model.Member;
import com.tts.civics.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberServiceInt {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}
	
	@Override
	public Member getMemberById(Long id) {
		return memberRepository.findMemberById(id);
	}
	
	@Override
	public void postMember(Member member) {
		memberRepository.save(member);
	}
	
	@Override
	public void updateMember(Long id, Member member) {
		Member updatedMember = memberRepository.findMemberById(id);
		updatedMember.setName(member.getName());
		updatedMember.setPhoto(member.getPhoto());
		updatedMember.setWhichChamber(member.getWhichChamber());
		updatedMember.setState(member.getState());
		updatedMember.setIsNewMember(member.getIsNewMember());
		updatedMember.setIsLeavingOffice(member.getIsLeavingOffice());
		updatedMember.setNumYearsInOffice(member.getNumYearsInOffice());
		updatedMember.setStatements(member.getStatements());
		updatedMember.setBillsIntroduced(member.getBillsIntroduced());
		updatedMember.setOfficeExpenses(member.getOfficeExpenses());
		updatedMember.setTravelExpenses(member.getTravelExpenses());
		
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
