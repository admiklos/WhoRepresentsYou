package com.tts.civics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.civics.model.CongressPerson;

@Repository
public interface MemberRepository extends CrudRepository<CongressPerson, Long> {
	
	public List<CongressPerson> findAll();

	public CongressPerson findMemberById(Long id);

}
