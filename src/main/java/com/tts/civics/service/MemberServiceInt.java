package com.tts.civics.service;

import java.util.List;

import com.tts.civics.model.CongressPerson;

public interface MemberServiceInt {

	public List<CongressPerson> getAllMembers();

	public CongressPerson getMemberById(Long id);

	void postMember(CongressPerson member);

	void deleteMember(Long id);

	void deleteAllMembers();

	void updateMember(Long id, CongressPerson member);

}
