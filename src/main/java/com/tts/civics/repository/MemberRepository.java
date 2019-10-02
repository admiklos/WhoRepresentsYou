package com.tts.civics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.civics.model.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
	
	public List<Member> findAll();

	public Member findMemberById(Long id);

}
