package com.tts.civics.service;

import java.util.List;

import com.tts.civics.model.Member;

public interface MemberServiceInt {

	public List<Member> getAllMembers();

	public Member getMemberById(Long id);

	void postMember(Member member);

	void deleteMember(Long id);

	void deleteAllMembers();

	void updateMember(Long id, Member member);

}
